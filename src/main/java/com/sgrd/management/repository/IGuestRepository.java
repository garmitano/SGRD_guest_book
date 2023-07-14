package com.sgrd.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrd.management.model.Guest;

public interface IGuestRepository extends JpaRepository<Guest, Long> {

}
