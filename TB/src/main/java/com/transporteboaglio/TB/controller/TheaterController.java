package com.transporteboaglio.TB.controller;

import com.transporteboaglio.TB.entity.TheaterEntity;
import com.transporteboaglio.TB.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theaters")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @GetMapping
    public ResponseEntity<List<TheaterEntity>> listTheaters() {
        List<TheaterEntity> theaters = theaterService.listTheaters();
        return ResponseEntity.ok(theaters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheaterEntity> getTheaterById(@PathVariable Long id) {
        TheaterEntity theater = theaterService.getTheaterById(id);
        if (theater != null) {
            return ResponseEntity.ok(theater);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TheaterEntity> createTheater(@RequestBody TheaterEntity theater) {
        TheaterEntity createdTheater = theaterService.createTheater(theater);
        return ResponseEntity.ok(createdTheater);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TheaterEntity> updateTheater(@PathVariable Long id, @RequestBody TheaterEntity theater) {
        TheaterEntity updatedTheater = theaterService.updateTheater(id, theater);
        if (updatedTheater != null) {
            return ResponseEntity.ok(updatedTheater);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheater(@PathVariable Long id) {
        theaterService.deleteTheater(id);
        return ResponseEntity.noContent().build();
    }
}

