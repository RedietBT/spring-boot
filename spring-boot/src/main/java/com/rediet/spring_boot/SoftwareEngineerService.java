package com.rediet.spring_boot;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers(){
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getEngineersById(Integer id) {
       return softwareEngineerRepository.findById(id)
               .orElseThrow(() -> new IllegalStateException(id +"not found"));
    }

    public void deleteSoftwareEngineerById(Integer id) {
       boolean exists = softwareEngineerRepository.existsById(id);
       if(!exists){
           throw new IllegalStateException(id + "not found");
       }
       softwareEngineerRepository.deleteById(id);
    }

    public void updateSoftwareEngineerById(Integer id, SoftwareEngineer update) {
        SoftwareEngineer softwareEngineer= softwareEngineerRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException(id + "not found"));
        softwareEngineer.setName(update.getName());
        softwareEngineer.setTechStack(update.getTechStack());
        softwareEngineerRepository.save(softwareEngineer);

        }
    }
