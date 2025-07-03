
 package com.latteIceCream.latte.controller;

 import com.latteIceCream.latte.domain.Brand;
 import com.latteIceCream.latte.dto.BrandDTO;
 import com.latteIceCream.latte.service.BrandService;

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
 @RequestMapping("/brands")
 @Validated
 public class BrandController

 {

    @Autowired
    BrandService brandService;

    @PostMapping
    public ResponseEntity<Brand> post(@Valid @RequestBody BrandDTO brnDTO)

    {

       Brand brand = brandService.create(brnDTO);

       if(brand == null){ return ResponseEntity.badRequest().build(); }

       URI location = ServletUriComponentsBuilder
                      .fromCurrentRequest()
                      .path("/{id}")
                      .buildAndExpand(brand.getId())
                      .toUri();

       return ResponseEntity.created(location).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> get(@PathVariable Long id)

    { return ResponseEntity.of(Optional.ofNullable(brandService.read(id))); }

    @PatchMapping("/{id}") public ResponseEntity<Brand> patch
    (@PathVariable Long id, @Valid @RequestBody BrandDTO brnDTO)

    {

       Brand brand = brandService.update(id, brnDTO);

       if(brand == null) { return ResponseEntity.notFound().build(); }

       return ResponseEntity.ok(brand);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id)

    {

       if(!brandService.delete(id))

       { return ResponseEntity.internalServerError().build(); }

       return ResponseEntity.noContent().build();

    }

    @GetMapping
    public ResponseEntity<List<Brand>> getAll()
    { return ResponseEntity.ok(brandService.getAll()); }

  }
