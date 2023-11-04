package com.transporteboaglio.TB.repository;


import com.transporteboaglio.TB.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
