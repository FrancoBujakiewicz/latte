
 package com.latteIceCream.latte.repository;

 import com.latteIceCream.latte.domain.Product;
 import org.springframework.data.jpa.repository.JpaRepository;

 public interface ProductRepository extends JpaRepository<Product, Long> {}
