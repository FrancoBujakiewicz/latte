
 package com.latteIceCream.latte.dto;

 import jakarta.validation.constraints.NotBlank;
 import jakarta.validation.constraints.Size;

 import java.math.BigDecimal;

 public record PortionSizeDTO

 (

    @NotBlank(message = "Portion size name can't be empty!")
    @Size(max = 30, message = "The name is so large!")
    String name,

    @NotBlank(message = "Portion description can't be empty!")
    @Size(max = 255, message = "The description is so large!")
    String description,

    @Size(max = 6, message = "The price is so large!")
    BigDecimal price,

    Boolean available

 )

 implements DTO {}
