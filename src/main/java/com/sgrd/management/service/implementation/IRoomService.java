package com.sgrd.management.service.implementation;

import java.util.List;

import com.sgrd.management.model.Room;

public interface IRoomService {
    public List<Room> listAllRoom();

    public Room addNewRoom(Room room);

    public Room getRoomById(Long id);

    public Room updateRoom(Room room);

    public void deleteRoom(Long id);
}
