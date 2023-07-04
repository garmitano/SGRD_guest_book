package com.sgrd.management.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sgrd.management.model.Room;
import com.sgrd.management.model.Enum.RoomStateEnum;
import com.sgrd.management.repository.IRoomRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// @Rollback(false)
public class RoomTest {

    @Autowired
    private IRoomRepository repository;

    @Test
    public void saveRoom() {
        Room room = new Room(null, 0, null, null, null, null);

        repository.save(room);

        repository.flush();

        assertEquals(1, repository.findAll().size());

    }

}
