package service;

import java.util.List;

import com.service.clinic.exception.OwnerNotFoundException;
import com.service.clinic.model.Owner;

public interface PetClinicService {

    //CRUD 

    List<Owner> findOwners();
    List<Owner> findOwnersLastName(String lastName);

    //Id ile eşleşen bir owner nesnesi varsa onu dönecek yoksa OwnerNotFoundException fırlatacak.
    Owner findOwner(Long id) throws OwnerNotFoundException;

    void createOwner(Owner owner);
    void update(Owner owner);
    void deleteOwner(Long id);
    
}
