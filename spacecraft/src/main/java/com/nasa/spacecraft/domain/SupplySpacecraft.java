package com.nasa.spacecraft.domain;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "supply_spacecraft")
@PrimaryKeyJoinColumn(name = "spacecraft_id")
public class SupplySpacecraft extends Spacecraft {
    private String supplyType;

    @Builder
    public SupplySpacecraft(Long id, String name, int maxSpeed, String supplyType) {
        super(id, name, maxSpeed);
        this.supplyType = supplyType;
    }
}