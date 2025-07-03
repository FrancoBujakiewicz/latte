
 package com.latteIceCream.latte.service;

 import java.util.List;

 public interface EntityService<T, Long, DTO>

 {

    T create(DTO dto);
    T read(Long id);
    T update(Long id, DTO dto);
    boolean delete(Long id);

    List getAll();

 }
