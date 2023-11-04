package com.transporteboaglio.TB.service;

import com.transporteboaglio.TB.entity.Theater;

import java.util.List;

public interface TheaterService {
    List<Theater> listTheaters();
    Theater getTheaterById(Long id);
    Theater createTheater(Theater theater);
    Theater updateTheater(Long id, Theater theater);
    void deleteTheater(Long id);
}

