package com.service.clinic.dao.mem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.service.clinic.dao.OwnerRepository;
import com.service.clinic.model.Owner;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class OwnerRepositoryMemoryImpl implements OwnerRepository{

    private Map<Long, Owner> ownersMap = new HashMap<>();

    public OwnerRepositoryMemoryImpl(){
        Owner owner= new Owner();
        owner.setId(1L);
        owner.setFirstName("Emre");
        owner.setLastName("Karadag");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Ciguli");
        owner2.setLastName("KK");

        ownersMap.put(owner.getId(), owner);
        ownersMap.put(owner2.getId(), owner2);

        log.info("Owners Map : {}", ownersMap);
        

    }


    @Override
    public List<Owner> findAll() {
        return new ArrayList<>(ownersMap.values());
    }

    @Override
    public Owner findById(Long id) {
        return ownersMap.get(id);
    }

    @Override
    public List<Owner> findByLastName(String lastName) {
        //Sadece lastName input argümanı ile eşleşen kayıtları döndürüyoruz
        return ownersMap.values().stream().filter(o->o.getLastName().equals(lastName)).collect(Collectors.toList());
    }

    @Override
    public void create(Owner owner) {

        owner.setId(new Date().getTime());
        ownersMap.put(owner.getId(), owner);
    }

    @Override
    public Owner update(Owner owner) {
        ownersMap.replace(owner.getId(), owner);
        return owner;
    }

    @Override
    public void delete(Long id) {
        ownersMap.remove(id);        
    }
    
}
