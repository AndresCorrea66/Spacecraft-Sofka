package com.nasa.spacecraft.service;

import com.nasa.spacecraft.domain.Spacecraft;
import com.nasa.spacecraft.factory.SpacecraftFactory;
import com.nasa.spacecraft.factory.SpacecraftType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpacecraftInventory {

    private static final int INITIAL_INVENTORY_COUNT_PER_TYPE = 3;
    private final SpacecraftFactory spacecraftFactory;

    public SpacecraftInventory(SpacecraftFactory spacecraftFactory) {
        this.spacecraftFactory = spacecraftFactory;
    }

    public List<Spacecraft> createInitialInventory() {
        List<Spacecraft> initialInventory = new ArrayList<>();
        for (int i = 0; i < INITIAL_INVENTORY_COUNT_PER_TYPE; i++) {
            for (SpacecraftType spacecraftType : SpacecraftType.values()) {
                initialInventory.add(this.spacecraftFactory.create(spacecraftType));
            }
        }
        return initialInventory;
    }

    public Spacecraft addSpacecraft(SpacecraftType spacecraftType) {
        return this.spacecraftFactory.create(spacecraftType);
    }

}
