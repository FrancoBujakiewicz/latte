
 package com.latteIceCream.latte;

 import org.junit.jupiter.api.Test;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.http.MediaType;
 import org.springframework.test.context.ActiveProfiles;
 import org.springframework.test.web.servlet.MockMvc;
 import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
 import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

 import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

 @SpringBootTest
 @AutoConfigureMockMvc
 @ActiveProfiles("test")
 public class FlavorEntityTest {

   // @Autowired
   // MockMvc mockMvc;

    @Test
    public void flavorPostRequest() throws Exception

    {
/*
       mockMvc.perform
       (

          MockMvcRequestBuilders.post("/flavor/{id}")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isCreated())
          .andExpect
          (MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)

       );
*/
    }

 }
