
 package com.latteIceCream.latte.dto;

 import jakarta.validation.constraints.NotBlank;
 import jakarta.validation.constraints.Size;

 public record BrandDTO

 (

    @NotBlank(message = "Brand name can't be empty!")
    @Size(max = 30, message = "The name is so large!")
    String name

 )

 implements DTO {}
