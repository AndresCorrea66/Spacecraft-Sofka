package com.nasa.spacecraft.controller;

import com.nasa.spacecraft.domain.AddSpacecraftDTO;
import com.nasa.spacecraft.domain.Spacecraft;
import com.nasa.spacecraft.factory.SpacecraftType;
import com.nasa.spacecraft.service.SpacecraftService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spacecrafts")
@CrossOrigin(origins = "*")
public class SpacecraftController {
    private final SpacecraftService spacecraftService;

    public SpacecraftController(SpacecraftService spacecraftService) {
        this.spacecraftService = spacecraftService;
    }

    @PostMapping
    public ResponseEntity<Spacecraft> addSpacecraft(@RequestBody AddSpacecraftDTO addSpacecraftDTO) {
        SpacecraftType spacecraftType = SpacecraftType.valueOf(addSpacecraftDTO.getSpacecraftType());
        Spacecraft savedSpacecraft = spacecraftService.addSpacecraft(spacecraftType);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSpacecraft);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Spacecraft>> searchSpacecraft(@RequestParam String keywords) {
        List<Spacecraft> spacecrafts = spacecraftService.searchSpacecraft(keywords);
        return ResponseEntity.ok(spacecrafts);
    }

    @GetMapping("/search-by-speed")
    public ResponseEntity<List<Spacecraft>> searchMaxSpeedBetween(@RequestParam int minSpeed, @RequestParam int maxSpeed) {
        List<Spacecraft> spacecrafts = spacecraftService.searchMaxSpeedBetween(minSpeed, maxSpeed);
        return ResponseEntity.ok(spacecrafts);
    }

    @GetMapping
    public ResponseEntity<List<Spacecraft>> findAll() {
        List<Spacecraft> spacecrafts = spacecraftService.findAll();
        return ResponseEntity.ok(spacecrafts);
    }
}

