
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
 import org.springframework.web.bind.annotation.*;
 import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

 @RestController
 @RequestMapping("/flavors")
 public class FlavorController

 {

    @Autowired
    FlavorService flavorService;

    @PostMapping
    public ResponseEntity<Flavor> postFlavor(@Valid @RequestBody FlavorDTO flvDTO)

    {

       Flavor flavor = flavorService.createFlavor(flvDTO);

       if(flavor == null){ return ResponseEntity.badRequest().build(); }

       URI location = ServletUriComponentsBuilder
                      .fromCurrentRequest()
                      .path("/{id}")
                      .buildAndExpand(flavor.getName())
                      .toUri();

       return ResponseEntity.created(location).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Flavor> getFlavor(@PathVariable Long id)

    { return ResponseEntity.of(Optional.ofNullable(flavorService.readFlavor(id))); }

    @PatchMapping("/{id}") public ResponseEntity<Flavor> patchFlavor
    (@PathVariable Long id, @Valid @RequestBody FlavorDTO flvDTO)

    {

       Flavor flavor = flavorService.updateFlavor(id, flvDTO);

       if(flavor == null) { return ResponseEntity.notFound().build(); }

       return ResponseEntity.ok(flavor);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFlavor(@PathVariable Long id)

    {

       if(!flavorService.deleteFlavor(id)) { return ResponseEntity.internalServerError().build(); }

       return ResponseEntity.noContent().build();

    }

    @GetMapping
    public ResponseEntity<List<Flavor>> getAll(){ return ResponseEntity.ok(flavorService.getAllFlavors()); }

 }
