package com.sgrd.management.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sgrd.management.model.Room;
import com.sgrd.management.model.RoomType;
import com.sgrd.management.model.Enum.RoomStateEnum;
import com.sgrd.management.model.Enum.RoomTypeEnum;
import com.sgrd.management.repository.IRoomRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoomTest {

    @Autowired
    private IRoomRepository repository;

    @Test
    public void saveRoom() {

        RoomType roomType = new RoomType(RoomTypeEnum.SIMPLE, 5500);
        Room room = new Room(12, RoomStateEnum.EN_MANTENIMIENTO, roomType);

        repository.save(room);

        repository.flush();

        assertEquals(2, repository.findAll().size());

    }

}
