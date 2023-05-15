package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entity.Theater;

@Repository
public interface ITheaterRepository extends JpaRepository<Theater,Long>{

}
