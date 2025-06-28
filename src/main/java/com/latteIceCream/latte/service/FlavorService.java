
 package com.latteIceCream.latte.service;

 import com.latteIceCream.latte.domain.Flavor;
 import com.latteIceCream.latte.dto.FlavorDTO;
 import com.latteIceCream.latte.repository.FlavorRepository;

 import org.springframework.stereotype.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.transaction.annotation.Transactional;

 import java.util.List;

 @Service
 public class FlavorService

 {

    @Autowired
    FlavorRepository flvRepo;

    @Transactional
    public Flavor createFlavor(FlavorDTO flvDTO)

    { return flvRepo.save(new Flavor(flvDTO.name(), flvDTO.description(), flvDTO.available())); }

    public Flavor readFlavor(Long id) { return flvRepo.findById(id).orElse(null); }

    @Transactional
    public Flavor updateFlavor(Long id, FlavorDTO flvDTO)

    {

       return flvRepo.findById(id).map(flavor ->

          {

             if (flvDTO.name() != null) { flavor.setName(flvDTO.name()); }
             if (flvDTO.description() != null) { flavor.setDescription(flvDTO.description()); }
             if (flvDTO.available() != null) { flavor.setAvailable(flvDTO.available()); }

             return flvRepo.save(flavor);

          }

       ).orElse(null);

    }

    @Transactional
    public boolean deleteFlavor(Long id)

    {

       if(flvRepo.findById(id).isEmpty()) { return false; }

       flvRepo.deleteById(id); return true;

    }

    public List<Flavor> getAllFlavors() { return flvRepo.findAll(); }

 }
