
 package com.latteIceCream.latte.dto;

 import com.latteIceCream.latte.domain.Brand;
 import jakarta.validation.constraints.NotBlank;
 import jakarta.validation.constraints.NotNull;
 import jakarta.validation.constraints.Positive;
 import jakarta.validation.constraints.Size;

 import java.math.BigDecimal;

 public record ProductDTO

 (

    @NotBlank(message = "Product name can't be empty!")
    @Size(max = 30, message = "The name is so large!")
    String name,

    @NotBlank(message = "Product description can't be empty!")
    @Size(max = 255, message = "The description is so large!")
    String description,

    @Size(max = 6, message = "The price is so large!")
    BigDecimal price,

    @NotNull(message = "Product must have a brand")
    Brand brand,

    @Positive(message = "Stock can't be negative")
    @Size(max = 3, message = "The stock is so large!")
    Integer stock

 )

 implements DTO {}
