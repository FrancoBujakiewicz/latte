
 package com.latteIceCream.latte.controller;

 import com.latteIceCream.latte.domain.PortionSize;
 import com.latteIceCream.latte.dto.PortionSizeDTO;
 import com.latteIceCream.latte.service.PortionSizeService;

 import jakarta.validation.Valid;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
 import org.springframework.validation.annotation.Validated;
 import org.springframework.web.bind.annotation.*;
 import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

 import java.net.URI;
 import java.util.List;
 import java.util.Optional;

 @RestController
 @RequestMapping("/portionSizes")
 @Validated
 public class PortionSizeController

 {

    @Autowired
    PortionSizeService portionSizeService;

    @PostMapping
    public ResponseEntity<PortionSize> post(@Valid @RequestBody PortionSizeDTO pszDTO)

    {

       PortionSize portionSize = portionSizeService.create(pszDTO);

       if(portionSize == null){ return ResponseEntity.badRequest().build(); }

       URI location = ServletUriComponentsBuilder
                      .fromCurrentRequest()
                      .path("/{id}")
                      .buildAndExpand(portionSize.getId())
                      .toUri();

       return ResponseEntity.created(location).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<PortionSize> get(@PathVariable Long id)

    { return ResponseEntity.of(Optional.ofNullable(portionSizeService.read(id))); }

    @PatchMapping("/{id}") public ResponseEntity<PortionSize> patch
    (@PathVariable Long id, @Valid @RequestBody PortionSizeDTO pszDTO)

    {

       PortionSize portionSize = portionSizeService.update(id, pszDTO);

       if(portionSize == null) { return ResponseEntity.notFound().build(); }

       return ResponseEntity.ok(portionSize);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id)

    {

       if(!portionSizeService.delete(id))

       { return ResponseEntity.internalServerError().build(); }

       return ResponseEntity.noContent().build();

    }

       @GetMapping
       public ResponseEntity<List<PortionSize>> getAll()
       { return ResponseEntity.ok(portionSizeService.getAll()); }

 }
