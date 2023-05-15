package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.movie.entity.Ticket;

@Repository
@Transactional
public interface ITicketRepository extends  JpaRepository<Ticket,Long>{
	public  List<Ticket> findByUserId(Long userId);
}
