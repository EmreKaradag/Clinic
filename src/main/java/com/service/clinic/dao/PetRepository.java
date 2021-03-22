package com.service.clinic.dao;

import java.util.List;

import com.service.clinic.model.Pet;

public interface PetRepository {
 
    //sorgulama ve CRUD işlemleri
    Pet findById(Long id);
    List<Pet> findByOwnerId(Long ownerId);

    void create(Pet pet);
    Pet update(Pet pet);
    void delete(Long id);
    void deleteByOwnerId(Long ownerId);

}
