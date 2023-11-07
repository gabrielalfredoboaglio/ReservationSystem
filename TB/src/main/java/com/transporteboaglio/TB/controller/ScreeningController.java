package com.transporteboaglio.TB.controller;

import com.transporteboaglio.TB.entity.ScreeningEntity;
import com.transporteboaglio.TB.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screenings")
public class ScreeningController {

    @Autowired
    private  ScreeningService screeningService;

    @GetMapping
    public List<ScreeningEntity> listScreenings() {
        return screeningService.listScreenings();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ScreeningEntity> getScreening(@PathVariable Long id) {
        ScreeningEntity screening = screeningService.getScreeningById(id);
        if (screening != null) {
            return ResponseEntity.ok(screening);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ScreeningEntity> createScreening(@RequestBody ScreeningEntity screening) {
        ScreeningEntity createdScreening = screeningService.createScreening(screening);
        return ResponseEntity.ok(createdScreening);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ScreeningEntity> updateScreening(@PathVariable Long id, @RequestBody ScreeningEntity screening) {
        ScreeningEntity updatedScreening = screeningService.updateScreening(id, screening);
        if (updatedScreening != null) {
            return ResponseEntity.ok(updatedScreening);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteScreening(@PathVariable Long id) {
        screeningService.deleteScreening(id);
        return ResponseEntity.noContent().build();
    }
}

