package com.nasa.spacecraft.service;

import com.nasa.spacecraft.domain.Spacecraft;
import com.nasa.spacecraft.factory.SpacecraftType;
import com.nasa.spacecraft.repository.SpacecraftRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpacecraftService {
    private final SpacecraftRepository spacecraftRepository;
    private final SpacecraftInventory initialInventory;

    public SpacecraftService(SpacecraftRepository spacecraftRepository
            , SpacecraftInventory initialInventory) {
        this.spacecraftRepository = spacecraftRepository;
        this.initialInventory = initialInventory;
        this.initialInventory.createInitialInventory();
    }

    public Spacecraft addSpacecraft(SpacecraftType spacecraftType) {
        return this.initialInventory.addSpacecraft(spacecraftType);
    }

    public List<Spacecraft> searchSpacecraft(String keywords) {
        return spacecraftRepository.findByNameContainingIgnoreCase(keywords);
    }

    public List<Spacecraft> searchMaxSpeedBetween(int minSpeed, int maxSpeed) {
        return spacecraftRepository.findByMaxSpeedBetween(minSpeed, maxSpeed);
    }

    public List<Spacecraft> findAll() {
        return spacecraftRepository.findAll();
    }

}
