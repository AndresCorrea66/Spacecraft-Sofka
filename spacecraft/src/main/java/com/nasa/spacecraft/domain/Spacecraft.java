package com.nasa.spacecraft.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.*;

import java.awt.print.Book;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "spacecraft")
@DiscriminatorColumn(name="REF_TYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Spacecraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int maxSpeed;
}