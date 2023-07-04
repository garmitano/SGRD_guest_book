package com.sgrd.management.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sgrd.management.model.RoomType;
import com.sgrd.management.model.Enum.RoomTypeEnum;
import com.sgrd.management.repository.IRoomTypeRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// @Rollback(false)
public class RoomTypeTest {

    @Autowired
    private IRoomTypeRepository repository;

    @Test
    public void saveRoom() {
        RoomType roomType = new RoomType(null, null, 0, null, null);

        repository.save(roomType);

        repository.flush();

        assertEquals(1, repository.findAll().size());

    }

}
