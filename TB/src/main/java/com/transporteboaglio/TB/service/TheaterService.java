package com.transporteboaglio.TB.service;

import com.transporteboaglio.TB.entity.TheaterEntity;

import java.util.List;

public interface TheaterService {
    List<TheaterEntity> listTheaters();
    TheaterEntity getTheaterById(Long id);
    TheaterEntity createTheater(TheaterEntity theater);
    TheaterEntity updateTheater(Long id, TheaterEntity theater);
    void deleteTheater(Long id);
}

