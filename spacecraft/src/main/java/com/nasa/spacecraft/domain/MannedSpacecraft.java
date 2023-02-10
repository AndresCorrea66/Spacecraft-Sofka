package com.nasa.spacecraft.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "manned_spacecraft")
@PrimaryKeyJoinColumn(name = "spacecraft_id")
public class MannedSpacecraft extends Spacecraft {
    private int numberOfAstronauts;

    @Builder
    public MannedSpacecraft(Long id, String name, int maxSpeed, int numberOfAstronauts) {
        super(id, name, maxSpeed);
        this.numberOfAstronauts = numberOfAstronauts;
    }
}
