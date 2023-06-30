package com.sgrd.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrd.management.model.GuestType;

public interface IGuestTypeRepository extends JpaRepository<GuestType, Long> {

}
