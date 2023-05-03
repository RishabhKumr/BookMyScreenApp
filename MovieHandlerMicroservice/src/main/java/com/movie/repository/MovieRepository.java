package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.movie.entity.Movie;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie,Long>{
public List<Movie> findByMovieName(String movieName);
public List<Movie> findByMovieGenre(String movieGenre);
}
