
 package com.latteIceCream.latte.service;

 import com.latteIceCream.latte.domain.Flavor;
 import com.latteIceCream.latte.repository.FlavorRepository;

 import org.springframework.stereotype.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.transaction.annotation.Transactional;

 import java.util.List;
 import java.util.Optional;

 @Service
 public class FlavorService

 {

    @Autowired
    FlavorRepository flavorRepo;

    @Transactional
    public Flavor createFlavor(Flavor flavor) { return flavorRepo.save(flavor); }

    public Flavor readFlavor(String name)

    {

       Optional<Flavor> flavor = flavorRepo.findByName(name);
       return flavor.orElse(null);

    }

   // @Transactional
   // public Flavor updateFlavor(Flavor flavor){}

    @Transactional
    public boolean deleteFlavor(Long id)

    {

       Optional<Flavor> flavor = flavorRepo.findById(id);

       if(!flavor.isPresent()){ return false; }

       flavorRepo.deleteById(id); return true;

    }

    public List<Flavor> getAllFlavors() { return flavorRepo.findAll(); }

 }
