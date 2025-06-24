
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
    FlavorRepository flvRepo;

    @Transactional
    public Flavor createFlavor(FlavorDTO flvDTO)

    {

        Flavor flavor = new Flavor(flvDTO.name(), flvDTO.description(), flvDTO.available());

        return flvRepo.save(flavor);

    }

    public Flavor readFlavor(String name)

    {

       Optional<Flavor> flavor = flvRepo.findByName(name);
       return flavor.orElse(null);

    }

    @Transactional
    public Flavor updateFlavor(String name, FlavorDTO flvDTO)

    {

       Optional<Flavor> wrappedFlavor = flvRepo.findByName(name);

       Flavor flavor = wrappedFlavor.orElse(null);

       if(flavor == null) { return null; }

       if(!(flvDTO.name() == null)) { flavor.setName(flvDTO.name()); }
       if(!(flvDTO.available() == null)) { flavor.setAvailable(flvDTO.available()); }

       return flvRepo.save(flavor);

    }

    @Transactional
    public boolean deleteFlavor(String name)

    {

       Optional<Flavor> flavor = flvRepo.findByName(name);

       if(flavor.isEmpty()){ return false; }

       flvRepo.deleteByName(name); return true;

    }

    public List<Flavor> getAllFlavors() { return flvRepo.findAll(); }

 }
