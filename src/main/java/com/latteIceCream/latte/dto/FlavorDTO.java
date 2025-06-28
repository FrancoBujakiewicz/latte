
 package com.latteIceCream.latte.dto;

 import jakarta.validation.constraints.NotBlank;
 import jakarta.validation.constraints.Size;

 public record FlavorDTO

 (

    @NotBlank(message = "Flavor name can't be empty!")
    @Size(max = 30, message = "The name is so large!")
    String name,

    @NotBlank(message = "Flavor description can't be empty!")
    @Size(max = 255, message = "The description is so large!")
    String description,

    Boolean available

 )

 {}
