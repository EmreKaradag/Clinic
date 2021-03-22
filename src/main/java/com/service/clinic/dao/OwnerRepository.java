package com.service.clinic.dao;

import java.util.List;

import com.service.clinic.model.Owner;

public interface OwnerRepository {

    //sorgulama ve CRUD işlemleri
    List<Owner> findAll();
    Owner findById(Long id);
    List<Owner> findByLastName(String lastName);

    void create(Owner owner);
    Owner update(Owner owner);
    void delete(Long id);
    
}
