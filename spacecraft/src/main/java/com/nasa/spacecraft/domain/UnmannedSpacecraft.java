package com.nasa.spacecraft.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "unmanned_spacecraft")
@PrimaryKeyJoinColumn(name = "spacecraft_id")
public class UnmannedSpacecraft extends Spacecraft {
    private String mission;

    @Builder
    public UnmannedSpacecraft(Long id, String name, int maxSpeed, String mission) {
        super(id, name, maxSpeed);
        this.mission = mission;
    }
}