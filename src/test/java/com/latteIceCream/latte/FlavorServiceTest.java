
 package com.latteIceCream.latte;

 import com.latteIceCream.latte.domain.Flavor;
 import com.latteIceCream.latte.dto.FlavorDTO;
 import com.latteIceCream.latte.service.FlavorService;

 import org.junit.jupiter.api.Test;
 import org.junit.jupiter.api.Assertions;

 public class FlavorServiceTest

 {

    @Test
    public void test()

    {

       FlavorService flvService = new FlavorService();

       FlavorDTO flvDTO = new FlavorDTO("Chocolate", "Classic flavor", true);

       final Flavor expected = flvService.createFlavor(flvDTO);
       final Flavor actual = flvService.createFlavor(flvDTO);

       Assertions.assertEquals(expected, actual);

    }

 }
