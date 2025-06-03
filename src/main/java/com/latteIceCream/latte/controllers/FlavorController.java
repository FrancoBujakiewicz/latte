
 package com.latteIceCream.latte.controllers;

 import com.latteIceCream.latte.domain.Flavor;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 @RestController
 @RequestMapping("/flavors")
 public class FlavorController

 {

    @PostMapping("/{flavor}")
    public ResponseEntity<?> postFlavor(@PathVariable Flavor flavor)

    { return ResponseEntity.ok(null); }

 }
