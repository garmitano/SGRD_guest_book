package com.sgrd.management.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sgrd.management.model.Person;
import com.sgrd.management.repository.IPersonRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// @Rollback(false)
public class PersonTest {
    @Autowired
    private IPersonRepository repository;

    @Test
    public void savePerson() {
        Person person = new Person(null, 0, null, null, null, null, null, null, null, null);

        repository.save(person);

        repository.flush();

        assertEquals(1, repository.findAll().size());

    }

}