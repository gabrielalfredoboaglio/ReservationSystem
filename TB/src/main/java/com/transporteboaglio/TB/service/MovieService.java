package com.transporteboaglio.TB.service;

import com.transporteboaglio.TB.entity.MovieEntity;

import java.util.List;

public interface MovieService {
    List<MovieEntity> listMovies();
    MovieEntity getMovieById(Long id);
    MovieEntity createMovie(MovieEntity movie);
    MovieEntity updateMovie(Long id, MovieEntity movie);
    void deleteMovie(Long id);


}
