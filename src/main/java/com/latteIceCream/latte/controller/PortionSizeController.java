
 package com.latteIceCream.latte.controller;

 import com.latteIceCream.latte.domain.PortionSize;
 import com.latteIceCream.latte.dto.PortionSizeDTO;
 import com.latteIceCream.latte.service.PortionSizeService;

 import jakarta.validation.Valid;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;
 import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

 import java.net.URI;
 import java.util.List;
 import java.util.Optional;

 @RestController
 @RequestMapping("/portionSizes")
 public class PortionSizeController

 {

    @Autowired
    PortionSizeService portionSizeService;

    @PostMapping
    public ResponseEntity<PortionSize> postPortionSize(@Valid @RequestBody PortionSizeDTO pszDTO)

    {

       PortionSize portionSize = portionSizeService.createPortionSize(pszDTO);

       if(portionSize == null){ return ResponseEntity.badRequest().build(); }

       URI location = ServletUriComponentsBuilder
                      .fromCurrentRequest()
                      .path("/{id}")
                      .buildAndExpand(portionSize.getName())
                      .toUri();

       return ResponseEntity.created(location).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<PortionSize> getPortionSize(@PathVariable Long id)

    { return ResponseEntity.of(Optional.ofNullable(portionSizeService.readPortionSize(id))); }

    @PatchMapping("/{id}") public ResponseEntity<PortionSize> patchPortionSize
    (@PathVariable Long id, @Valid @RequestBody PortionSizeDTO pszDTO)

    {

       PortionSize portionSize = portionSizeService.updatePortionSize(id, pszDTO);

       if(portionSize == null) { return ResponseEntity.notFound().build(); }

       return ResponseEntity.ok(portionSize);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePortionSize(@PathVariable Long id)

    {

       if(!portionSizeService.deletePortionSize(id))

       { return ResponseEntity.internalServerError().build(); }

       return ResponseEntity.noContent().build();

    }

       @GetMapping
       public ResponseEntity<List<PortionSize>> getAll()
       { return ResponseEntity.ok(portionSizeService.getAllPortionSizes()); }

 }
