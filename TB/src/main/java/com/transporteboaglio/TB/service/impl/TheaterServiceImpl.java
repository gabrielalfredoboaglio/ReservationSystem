package com.transporteboaglio.TB.service.impl;

import com.transporteboaglio.TB.entity.TheaterEntity;
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
    public List<TheaterEntity> listTheaters() {
        return theaterRepository.findAll();
    }

    @Override
    public TheaterEntity getTheaterById(Long id) {
        return theaterRepository.findById(id).orElse(null);
    }

    @Override
    public TheaterEntity createTheater(TheaterEntity theater) {
        return theaterRepository.save(theater);
    }

    @Override
    public TheaterEntity updateTheater(Long id, TheaterEntity theater) {
        TheaterEntity existingTheater = theaterRepository.findById(id).orElse(null);
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

