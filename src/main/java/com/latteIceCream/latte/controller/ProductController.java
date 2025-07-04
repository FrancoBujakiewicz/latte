

 package com.latteIceCream.latte.controller;

 import com.latteIceCream.latte.domain.Product;
 import com.latteIceCream.latte.dto.ProductDTO;
 import com.latteIceCream.latte.service.ProductService;

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
 @RequestMapping("/products")
 @Validated
 public class ProductController

 {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<Product> post(@Valid @RequestBody ProductDTO pdtDTO)

    {

       Product product = productService.create(pdtDTO);

       if(product == null){ return ResponseEntity.badRequest().build(); }

       URI location = ServletUriComponentsBuilder
                      .fromCurrentRequest()
                      .path("/{id}")
                      .buildAndExpand(product.getId())
                      .toUri();

       return ResponseEntity.created(location).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id)

    { return ResponseEntity.of(Optional.ofNullable(productService.read(id))); }

    @PatchMapping("/{id}") public ResponseEntity<Product> patch
    (@PathVariable Long id, @Valid @RequestBody ProductDTO pdtDTO)

    {

       Product product = productService.update(id, pdtDTO);

       if(product == null) { return ResponseEntity.notFound().build(); }

       return ResponseEntity.ok(product);

     }

     @DeleteMapping("/{id}")
     public ResponseEntity delete(@PathVariable Long id)

     {

         if(!productService.delete(id)) { return ResponseEntity.internalServerError().build(); }

         return ResponseEntity.noContent().build();

     }

     @GetMapping
     public ResponseEntity<List<Product>> getAll(){ return ResponseEntity.ok(productService.getAll()); }

 }
