package com.sgrd.management.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sgrd.management.model.Registry;
import com.sgrd.management.repository.IRegistryRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RegistryTest {

    @Autowired
    private IRegistryRepository repository;

    @Test
    public void saveRegistry() {
        Registry registry = new Registry();

        repository.save(registry);
        repository.flush();

        assertEquals(1, repository.findAll().size());
    }

}