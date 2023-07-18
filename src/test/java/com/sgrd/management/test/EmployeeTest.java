package com.sgrd.management.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sgrd.management.model.Employee;
import com.sgrd.management.model.Enum.EmployeeTypeEnum;
import com.sgrd.management.repository.IEmployeeRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class EmployeeTest {

    @Autowired
    private IEmployeeRepository repository;

    @Test
    public void saveEmployee() {

        Employee employee = new Employee();

        employee.setDni(11172243);
        employee.setFullName("GUSTAVO ARMITANO");
        employee.setType(EmployeeTypeEnum.ADMINISTRADOR);

        repository.save(employee);

        repository.flush();

        assertEquals(2, repository.findAll().size());

    }

}
