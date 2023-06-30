package com.sgrd.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrd.management.model.Person;

public interface IPersonRepository extends JpaRepository<Person, Long> {

}
