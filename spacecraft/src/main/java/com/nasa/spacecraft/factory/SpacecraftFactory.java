package com.nasa.spacecraft.factory;

import com.nasa.spacecraft.domain.*;
import com.nasa.spacecraft.repository.SpacecraftRepository;
import org.springframework.stereotype.Component;

@Component
public class SpacecraftFactory {
    private final SpacecraftRepository spacecraftRepository;

    public SpacecraftFactory(SpacecraftRepository spacecraftRepository) {
        this.spacecraftRepository = spacecraftRepository;
    }

    public Spacecraft create(SpacecraftType type) {
        switch (type) {
            case MANNED:
                MannedSpacecraft mannedSpacecraft = MannedSpacecraft.builder()
                        .name("Manned")
                        .maxSpeed(100)
                        .numberOfAstronauts(10)
                        .build();
                spacecraftRepository.save(mannedSpacecraft);
                return mannedSpacecraft;
            case SPACE_PROBE:
                SpaceProbe spaceProbe = SpaceProbe.builder()
                        .name("Space probe")
                        .maxSpeed(200)
                        .target("Moon").build();
                spacecraftRepository.save(spaceProbe);
                return spaceProbe;
            case SUPPLY:
                SupplySpacecraft supplySpacecraft = SupplySpacecraft.builder()
                        .name("Supply")
                        .maxSpeed(500)
                        .supplyType("Food")
                        .build();
                spacecraftRepository.save(supplySpacecraft);
                return supplySpacecraft;
            case UNMANNED:
                UnmannedSpacecraft unmannedSpacecraft = UnmannedSpacecraft
                        .builder()
                        .name("Unmanned")
                        .maxSpeed(300)
                        .mission("Mars")
                        .build();
                spacecraftRepository.save(unmannedSpacecraft);
                return unmannedSpacecraft;
            default:
                throw new IllegalArgumentException("Invalid spacecraft type");
        }
    }

}
