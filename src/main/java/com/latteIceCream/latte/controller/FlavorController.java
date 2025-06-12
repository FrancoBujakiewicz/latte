
 package com.latteIceCream.latte.controller;

 import com.latteIceCream.latte.domain.Flavor;
 import com.latteIceCream.latte.service.FlavorService;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

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

       return new ResponseEntity<>(createdFlavor, HttpStatus.CREATED);

    }

    @GetMapping("/{name}")
    public ResponseEntity<Flavor> getFlavor(@PathVariable String name)

    {

       Flavor flavor = flavorService.readFlavor(name);

       if(flavor == null){ return ResponseEntity.notFound().build(); }

       return ResponseEntity.ok(flavor);

    }

 }
