package com.sgrd.management.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgrd.management.model.Room;
import com.sgrd.management.repository.IRoomRepository;

@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private IRoomRepository repository;

    @Override
    public List<Room> listAllRoom() {
        return repository.findAll();
    }

    @Override
    public Room addNewRoom(Room room) {
        return repository.save(room);
    }

    @Override
    public Room getRoomById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Room updateRoom(Room room) {
        return repository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        repository.deleteById(id);
    }

}
