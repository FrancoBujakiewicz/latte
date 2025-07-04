
 package com.latteIceCream.latte.controller;

 import java.net.URI;
 import java.util.List;
 import java.util.Optional;

 import com.latteIceCream.latte.domain.Flavor;
 import com.latteIceCream.latte.dto.FlavorDTO;
 import com.latteIceCream.latte.service.FlavorService;

 import jakarta.validation.Valid;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
 import org.springframework.validation.annotation.Validated;
 import org.springframework.web.bind.annotation.*;
 import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

 @RestController
 @RequestMapping("/flavors")
 @Validated
 public class FlavorController

 {

    @Autowired
    FlavorService flavorService;

    @PostMapping
    public ResponseEntity<Flavor> post(@Valid @RequestBody FlavorDTO flvDTO)

    {

       Flavor flavor = flavorService.create(flvDTO);

       if(flavor == null){ return ResponseEntity.badRequest().build(); }

       URI location = ServletUriComponentsBuilder
                      .fromCurrentRequest()
                      .path("/{id}")
                      .buildAndExpand(flavor.getId())
                      .toUri();

       return ResponseEntity.created(location).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Flavor> get(@PathVariable Long id)

    { return ResponseEntity.of(Optional.ofNullable(flavorService.read(id))); }

    @PatchMapping("/{id}") public ResponseEntity<Flavor> patch
    (@PathVariable Long id, @Valid @RequestBody FlavorDTO flvDTO)

    {

       Flavor flavor = flavorService.update(id, flvDTO);

       if(flavor == null) { return ResponseEntity.notFound().build(); }

       return ResponseEntity.ok(flavor);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id)

    {

       if(!flavorService.delete(id)) { return ResponseEntity.internalServerError().build(); }

       return ResponseEntity.noContent().build();

    }

    @GetMapping
    public ResponseEntity<List<Flavor>> getAll(){ return ResponseEntity.ok(flavorService.getAll()); }

 }
