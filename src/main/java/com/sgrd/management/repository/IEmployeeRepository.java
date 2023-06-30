package com.sgrd.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrd.management.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
