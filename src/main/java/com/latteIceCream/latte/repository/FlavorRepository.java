
 package com.latteIceCream.latte.repository;

 import com.latteIceCream.latte.domain.Flavor;
 import org.springframework.data.jpa.repository.JpaRepository;
 import java.util.Optional;

 public interface FlavorRepository extends JpaRepository<Flavor, Long>

 { Optional<Flavor> findByName(String name); }
