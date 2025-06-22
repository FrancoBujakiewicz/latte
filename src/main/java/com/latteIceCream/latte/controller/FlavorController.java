
 package com.latteIceCream.latte.controller;

 import java.net.URI;
 import java.util.List;

 import com.latteIceCream.latte.domain.Flavor;
 import com.latteIceCream.latte.dto.FlavorDTO;
 import com.latteIceCream.latte.service.FlavorService;

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
    public ResponseEntity<Flavor> postFlavor(@RequestBody Flavor flavor)

    {

       Flavor createdFlavor = flavorService.createFlavor(flavor);

       if(createdFlavor == null){ return ResponseEntity.badRequest().build(); }

       URI location = ServletUriComponentsBuilder
                      .fromCurrentRequest()
                      .path("/{name}")
                      .buildAndExpand(flavor.getName())
                      .toUri();

       return ResponseEntity.created(location).build();

    }

    @GetMapping("/{name}")
    public ResponseEntity<Flavor> getFlavor(@PathVariable String name)

    {

       Flavor flavor = flavorService.readFlavor(name);

       if(flavor == null){ return ResponseEntity.notFound().build(); }

       return ResponseEntity.ok(flavor);

    }

    @PatchMapping("/{name}")
    public ResponseEntity<Flavor> patchFlavor(@PathVariable String name, @RequestBody FlavorDTO flavorDTO)

    {

       Flavor flavor = flavorService.updateFlavor(name, flavorDTO);

       if(flavor == null){ return ResponseEntity.notFound().build(); }

       return ResponseEntity.ok(flavor);

    }

    @DeleteMapping("/{name}")
    public ResponseEntity deleteFlavor(@PathVariable String name)

    {

       if(!flavorService.deleteFlavor(name)) { return ResponseEntity.internalServerError().build(); }

       return ResponseEntity.noContent().build();

    }

    @GetMapping
    public ResponseEntity<List<Flavor>> getAll(){ return ResponseEntity.ok(flavorService.getAllFlavors()); }

 }
