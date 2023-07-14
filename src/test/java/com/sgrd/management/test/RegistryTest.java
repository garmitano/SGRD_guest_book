package com.sgrd.management.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sgrd.management.repository.IPersonRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// @Rollback(false)
public class RegistryTest {
    @Autowired
    private IPersonRepository repository;

    @Test
    public void saveRegistry() {

    }

}