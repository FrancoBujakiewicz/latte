
 package com.latteIceCream.latte.dto;

 import jakarta.validation.constraints.NotBlank;
 import jakarta.validation.constraints.NotNull;

 public record FlavorDTO

 (

    @NotBlank(message = "Name is mandatory") String name,
    @NotNull(message = "Availability is mandatory") Boolean available

 )

 {

 }
