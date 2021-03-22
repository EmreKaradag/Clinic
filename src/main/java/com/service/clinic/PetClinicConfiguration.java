package com.service.clinic;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetClinicConfiguration {

    @Value("${petclinic.display.owners.with.pets}")
    private boolean petclinicDisplayOwnersWithPet;

    @PostConstruct
    public void init(){
        System.out.println("Display owners with pets: " + petclinicDisplayOwnersWithPet);
    }
    
}
