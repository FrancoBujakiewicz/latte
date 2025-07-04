
 package com.latteIceCream.latte.service;

 import com.latteIceCream.latte.domain.Product;
 import com.latteIceCream.latte.dto.ProductDTO;
 import com.latteIceCream.latte.repository.ProductRepository;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import java.util.List;

 @Service
 public class ProductService implements EntityService<Product, Long, ProductDTO>

 {

    @Autowired
    ProductRepository pdtRepo;

    @Override
    @Transactional
    public Product create(ProductDTO pdtDTO)

    {

       return pdtRepo.save

       ( new Product

          (

             pdtDTO.name(),
             pdtDTO.description(),
             pdtDTO.price(),
             pdtDTO.brand(),
             pdtDTO.stock()

          )

       );

    }

     public Product read(Long id)

     { return pdtRepo.findById(id).orElse(null); }

     @Override
     @Transactional
     public Product update(Long id, ProductDTO pdtDTO)

     {

        return pdtRepo.findById(id).map(product ->

        {

           if (pdtDTO.name() != null) { product.setName(pdtDTO.name()); }
           if (pdtDTO.description() != null) { product.setDescription(pdtDTO.description()); }
           if (pdtDTO.price() != null) { product.setPrice(pdtDTO.price()); }
           if (pdtDTO.brand() != null) { product.setBrand(pdtDTO.brand()); }
           if (pdtDTO.stock() != null) { product.setStock(pdtDTO.stock()); }

           return pdtRepo.save(product);

        }

         ).orElse(null);

     }

     @Override
     @Transactional
     public boolean delete(Long id)

     {

         if(pdtRepo.findById(id).isEmpty()) { return false; }

         pdtRepo.deleteById(id); return true;

     }

     @Override
     public List<Product> getAll() { return pdtRepo.findAll(); }


 }
