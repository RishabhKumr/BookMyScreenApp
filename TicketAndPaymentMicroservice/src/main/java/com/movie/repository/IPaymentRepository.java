package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entity.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment,Long>{

}



