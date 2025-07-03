
 package com.latteIceCream.latte.service;

 import com.latteIceCream.latte.domain.Brand;
 import com.latteIceCream.latte.dto.BrandDTO;
 import com.latteIceCream.latte.repository.BrandRepository;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.transaction.annotation.Transactional;

 import java.util.List;

 public class BrandService implements EntityService<Brand, Long, BrandDTO>

 {


     @Autowired
     BrandRepository brnRepo;

     @Override
     @Transactional
     public Brand create(BrandDTO brnDTO) { return brnRepo.save(new Brand(brnDTO.name())); }

     public Brand read(Long id)

     { return brnRepo.findById(id).orElse(null); }

     @Override
     @Transactional
     public Brand update(Long id, BrandDTO brnDTO)

     {

        return brnRepo.findById(id).map(brand -> { if (brnDTO.name() != null) { brand.setName(brnDTO.name()); }

        return brnRepo.save(brand);

     }

     ).orElse(null);

     }

     @Override
     @Transactional
     public boolean delete(Long id)

     {

         if(brnRepo.findById(id).isEmpty()) { return false; }

         brnRepo.deleteById(id); return true;

     }

     @Override
     public List<Brand> getAll() { return brnRepo.findAll(); }

 }
