package com.nasa.spacecraft.repository;

import com.nasa.spacecraft.domain.Spacecraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpacecraftRepository extends JpaRepository<Spacecraft, Long> {
    // Simple spacecraft query
    List<Spacecraft> findByName(String name);

    // Simple spacecraft query
    List<Spacecraft> findByNameContainingIgnoreCase(String keywords);

    // Complex spacecraft query by multiple fields
    @Query("SELECT s FROM Spacecraft s WHERE s.maxSpeed >= :minSpeed AND s.maxSpeed <= :maxSpeed")
    List<Spacecraft> findByMaxSpeedBetween(@Param("minSpeed") int minSpeed, @Param("maxSpeed") int maxSpeed);
}