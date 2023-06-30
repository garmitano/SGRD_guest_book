package com.sgrd.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrd.management.model.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {

}
