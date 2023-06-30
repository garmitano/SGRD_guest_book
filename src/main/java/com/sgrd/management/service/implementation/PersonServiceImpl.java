package com.sgrd.management.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgrd.management.model.Person;
import com.sgrd.management.repository.IPersonRepository;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonRepository repository;

    @Override
    public List<Person> listAllPersons() {
        return repository.findAll();
    }

    @Override
    public Person addNewPerson(Person person) {
        return repository.save(person);
    }

    @Override
    public Person getPersonById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Person updatePerson(Person person) {
        return repository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        repository.deleteById(id);
    }

}
