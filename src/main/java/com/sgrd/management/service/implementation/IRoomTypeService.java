package com.sgrd.management.service.implementation;

import java.util.List;

import com.sgrd.management.model.RoomType;

public interface IRoomTypeService {
    public List<RoomType> listAllRoomTypes();

    public RoomType addNewRoomType(RoomType roomType);

    // public Person getPersonById(Long id);

    // public Person updatePerson(Person person);

    public void deleteRoomType(Long id);
}
