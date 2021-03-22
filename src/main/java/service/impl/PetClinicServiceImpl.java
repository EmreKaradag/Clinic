package service.impl;

import java.util.List;

import com.service.clinic.dao.OwnerRepository;
import com.service.clinic.exception.OwnerNotFoundException;
import com.service.clinic.model.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.PetClinicService;

@Service
public class PetClinicServiceImpl implements PetClinicService{

    private OwnerRepository ownerRepository;

    @Autowired
    public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> findOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public List<Owner> findOwnersLastName(String lastName) {
       return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Owner findOwner(Long id) throws OwnerNotFoundException {
        
        Owner owner = ownerRepository.findById(id);
        if(owner == null) throw new OwnerNotFoundException("Owner not found with id : " + id);

        return owner;
    }

    @Override
    public void createOwner(Owner owner) {
        ownerRepository.create(owner);
    }

    @Override
    public void update(Owner owner) {
        ownerRepository.update(owner);
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepository.delete(id);
    }
    
}
