
 package com.latteIceCream.latte.service;

 import com.latteIceCream.latte.domain.PortionSize;
 import com.latteIceCream.latte.dto.PortionSizeDTO;
 import com.latteIceCream.latte.repository.PortionSizeRepository;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import java.util.List;

 @Service
 public class PortionSizeService

 {

    @Autowired
    PortionSizeRepository pszRepo;

    @Transactional
    public PortionSize createPortionSize(PortionSizeDTO pszDTO)

    {

       return pszRepo.save( new PortionSize

       (pszDTO.name(), pszDTO.description(), pszDTO.price(), pszDTO.available()) );

    }

     public PortionSize readPortionSize(Long id)
     { return pszRepo.findById(id).orElse(null); }

     @Transactional
     public PortionSize updatePortionSize(Long id, PortionSizeDTO pszDTO)

     {

        return pszRepo.findById(id).map(portionSize ->

        {

           if (pszDTO.name() != null) { portionSize.setName(pszDTO.name()); }
           if (pszDTO.description() != null) { portionSize.setDescription(pszDTO.description()); }
           if (pszDTO.price() != null) { portionSize.setPrice(pszDTO.price()); }
           if (pszDTO.available() != null) { portionSize.setAvailable(pszDTO.available()); }

           return pszRepo.save(portionSize);

        }

         ).orElse(null);

     }

     @Transactional
     public boolean deletePortionSize(Long id)

     {

        if(pszRepo.findById(id).isEmpty()) { return false; }

        pszRepo.deleteById(id); return true;

     }

     public List<PortionSize> getAllPortionSizes() { return pszRepo.findAll(); }

 }
