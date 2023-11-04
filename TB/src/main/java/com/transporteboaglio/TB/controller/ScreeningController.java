package com.transporteboaglio.TB.controller;

import com.transporteboaglio.TB.entity.Screening;
import com.transporteboaglio.TB.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screenings")
public class ScreeningController {

    @Autowired
    private  ScreeningService screeningService;

    @GetMapping
    public List<Screening> listScreenings() {
        return screeningService.listScreenings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screening> getScreening(@PathVariable Long id) {
        Screening screening = screeningService.getScreeningById(id);
        if (screening != null) {
            return ResponseEntity.ok(screening);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Screening> createScreening(@RequestBody Screening screening) {
        Screening createdScreening = screeningService.createScreening(screening);
        return ResponseEntity.ok(createdScreening);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Screening> updateScreening(@PathVariable Long id, @RequestBody Screening screening) {
        Screening updatedScreening = screeningService.updateScreening(id, screening);
        if (updatedScreening != null) {
            return ResponseEntity.ok(updatedScreening);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteScreening(@PathVariable Long id) {
        screeningService.deleteScreening(id);
        return ResponseEntity.noContent().build();
    }
}
