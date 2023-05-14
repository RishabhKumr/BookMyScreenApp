package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.entity.Theater;

public interface ITheaterRepository extends JpaRepository<Theater,Long>{

}
