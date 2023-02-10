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
@Table(name = "space_probe")
@PrimaryKeyJoinColumn(name = "spacecraft_id")
public class SpaceProbe extends Spacecraft {
    private String target;

    @Builder
    public SpaceProbe(Long id, String name, int maxSpeed, String target) {
        super(id, name, maxSpeed);
        this.target = target;
    }
}