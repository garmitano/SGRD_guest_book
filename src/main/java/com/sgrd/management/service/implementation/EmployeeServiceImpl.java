package com.sgrd.management.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgrd.management.model.Employee;
import com.sgrd.management.repository.IEmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements IServiceBase<Employee> {

    @Autowired
    private IEmployeeRepository repository;

    @Override
    @Transactional
    public List<Employee> listAll() throws Exception {
        try {
            List<Employee> employee = repository.findAll();
            return employee;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Employee addNewOne(Employee entity) throws Exception {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Employee getOneById(Long id) throws Exception {
        try {
            return repository.getReferenceById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Employee updateOne(Employee entity, Long id) throws Exception {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void deleteOne(Long id) {
        repository.deleteById(id);
    }

}
