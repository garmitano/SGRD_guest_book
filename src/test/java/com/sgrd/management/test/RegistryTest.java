package com.sgrd.management.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sgrd.management.model.Employee;
import com.sgrd.management.model.Guest;
import com.sgrd.management.model.Registry;
import com.sgrd.management.model.RegistryDetail;
import com.sgrd.management.model.Room;
import com.sgrd.management.model.RoomType;
import com.sgrd.management.model.Enum.EmployeeTypeEnum;
import com.sgrd.management.model.Enum.GuestTypeEnum;
import com.sgrd.management.model.Enum.RoomStateEnum;
import com.sgrd.management.model.Enum.RoomTypeEnum;
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

        Employee employee1 = new Employee(73262626, "ALBERTO", EmployeeTypeEnum.ADMINISTRADOR);

        RoomType roomTypeDoble = new RoomType(RoomTypeEnum.DOBLE, 6000);

        Room room1 = new Room(7, RoomStateEnum.LIBRE, roomTypeDoble);

        Guest guest1 = new Guest(77173444, "GUSTAVO", GuestTypeEnum.CAMIONEROS);
        Guest guest2 = new Guest(77173333, "CECILIA", GuestTypeEnum.STIA);
        Guest guest3 = new Guest(7632653, "ARMANDO", GuestTypeEnum.STIA);

        List<RegistryDetail> registryDetails = new ArrayList<RegistryDetail>();

        RegistryDetail registryDetail1 = new RegistryDetail(guest1);
        RegistryDetail registryDetail2 = new RegistryDetail(guest2);
        RegistryDetail registryDetail3 = new RegistryDetail(guest3);

        registryDetails.add(registryDetail1);
        registryDetails.add(registryDetail2);
        registryDetails.add(registryDetail3);

        registry.setCheckin(LocalDate.of(2023, 10, 10));
        registry.setCheckout(LocalDate.of(2023, 12, 12));
        registry.setEmployee(employee1);
        registry.setRoom(room1);
        registry.setNumTicket("235623");
        registry.setRegistryDetails(registryDetails);

        repository.save(registry);
        repository.flush();

        assertEquals(3, repository.findAll().size());
    }

}