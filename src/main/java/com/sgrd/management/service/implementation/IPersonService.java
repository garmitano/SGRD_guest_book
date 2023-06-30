package com.sgrd.management.service.implementation;

import java.util.List;

import com.sgrd.management.model.Person;

public interface IPersonService {
    public List<Person> listAllPersons();

    public Person addNewPerson(Person person);

    public Person getPersonById(Long id);

    public Person updatePerson(Person person);

    public void deletePerson(Long id);
}
