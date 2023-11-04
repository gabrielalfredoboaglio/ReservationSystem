package com.transporteboaglio.TB.service;

import com.transporteboaglio.TB.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> listMovies();
    Movie getMovieById(Long id);
    Movie createMovie(Movie movie);
    Movie updateMovie(Long id, Movie movie);
    void deleteMovie(Long id);


}
