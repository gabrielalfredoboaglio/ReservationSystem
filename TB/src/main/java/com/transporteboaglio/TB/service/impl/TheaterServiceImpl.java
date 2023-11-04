package com.transporteboaglio.TB.service.impl;

import com.transporteboaglio.TB.entity.Theater;
import com.transporteboaglio.TB.repository.TheaterRepository;
import com.transporteboaglio.TB.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;


    @Override
    public List<Theater> listTheaters() {
        return theaterRepository.findAll();
    }

    @Override
    public Theater getTheaterById(Long id) {
        return theaterRepository.findById(id).orElse(null);
    }

    @Override
    public Theater createTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    @Override
    public Theater updateTheater(Long id, Theater theater) {
        Theater existingTheater = theaterRepository.findById(id).orElse(null);
        if (existingTheater != null) {
            theater.setId(id);
            return theaterRepository.save(theater);
        }
        return null; //
    }

    @Override
    public void deleteTheater(Long id) {
        theaterRepository.deleteById(id);
    }
}

