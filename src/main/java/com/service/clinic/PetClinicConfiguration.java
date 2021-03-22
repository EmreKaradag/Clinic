package com.service.clinic;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class PetClinicConfiguration {

    @Value("${petclinic.display.owners.with.pets}")
    private boolean petclinicDisplayOwnersWithPet;

    @PostConstruct
    public void init(){
        log.info("Display Owners With Pet : {}", petclinicDisplayOwnersWithPet);
    }
    
}
