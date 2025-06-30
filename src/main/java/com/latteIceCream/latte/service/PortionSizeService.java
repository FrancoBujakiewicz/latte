
 package com.latteIceCream.latte.service;

 import com.latteIceCream.latte.domain.PortionSize;
 import com.latteIceCream.latte.dto.PortionSizeDTO;
 import com.latteIceCream.latte.repository.PortionSizeRepository;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import java.util.List;

 @Service
 public class PortionSizeService implements CRUDService<PortionSize, Long, PortionSizeDTO>

 {

    @Autowired
    PortionSizeRepository pszRepo;

    @Override
    @Transactional
    public PortionSize create(PortionSizeDTO pszDTO)

    {

       return pszRepo.save( new PortionSize

       (pszDTO.name(), pszDTO.description(), pszDTO.price(), pszDTO.available()) );

    }

     public PortionSize read(Long id)

     { return pszRepo.findById(id).orElse(null); }

     @Override
     @Transactional
     public PortionSize update(Long id, PortionSizeDTO pszDTO)

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

     @Override
     @Transactional
     public boolean delete(Long id)

     {

        if(pszRepo.findById(id).isEmpty()) { return false; }

        pszRepo.deleteById(id); return true;

     }

     @Override
     public List<PortionSize> getAll() { return pszRepo.findAll(); }

 }
