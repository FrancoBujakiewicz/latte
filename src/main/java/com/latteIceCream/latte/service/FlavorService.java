
 package com.latteIceCream.latte.service;

 import com.latteIceCream.latte.domain.Flavor;
 import com.latteIceCream.latte.dto.FlavorDTO;
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

    @Transactional
    public Flavor updateFlavor(String name, FlavorDTO flavorDTO)

    {

       Optional<Flavor> wrappedFlavor = flavorRepo.findByName(name);

       Flavor flavor = wrappedFlavor.orElse(null);

       if(flavor == null) { return null; }

       if(!(flavorDTO.name() == null)) { flavor.setName(flavorDTO.name()); }
       if(!(flavorDTO.available() == null)) { flavor.setAvailable(flavorDTO.available()); }

       return flavorRepo.save(flavor);

    }

    @Transactional
    public boolean deleteFlavor(String name)

    {

       Optional<Flavor> flavor = flavorRepo.findByName(name);

       if(flavor.isEmpty()){ return false; }

       flavorRepo.deleteByName(name); return true;

    }

    public List<Flavor> getAllFlavors() { return flavorRepo.findAll(); }

 }
