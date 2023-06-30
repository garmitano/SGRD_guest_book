package com.sgrd.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrd.management.model.Registry;

public interface IRegistryRepository extends JpaRepository<Registry, Long> {

}
