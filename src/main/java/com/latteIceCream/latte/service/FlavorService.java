
 package com.latteIceCream.latte.service;

 import com.latteIceCream.latte.domain.Flavor;
 import com.latteIceCream.latte.repository.FlavorRepository;
 import org.springframework.stereotype.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.transaction.annotation.Transactional;

 @Service
 public class FlavorService

 {

    @Autowired
    FlavorRepository flavorRepo;

    @Transactional
    public void createFlavor(Flavor flavor) { flavorRepo.save(flavor); }

    public Flavor readFlavor(String name) { return flavorRepo.findByName(name); }

    @Transactional
    public void updateFlavor(Flavor flavor)

    {



    }

    @Transactional
    public void deleteFlavor() {}

 }
