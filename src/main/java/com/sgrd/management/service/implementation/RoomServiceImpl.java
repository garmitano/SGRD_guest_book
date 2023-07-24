package com.sgrd.management.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgrd.management.model.Room;
import com.sgrd.management.repository.IRoomRepository;

import jakarta.transaction.Transactional;

@Service
public class RoomServiceImpl implements IServiceBase<Room> {

    @Autowired
    private IRoomRepository repository;

    @Override
    @Transactional
    public List<Room> listAll() throws Exception {
        try {
            List<Room> rooms = repository.findAll();
            return rooms;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Room> listFree() throws Exception {
        try {
            List<Room> freeRooms = repository.freeRooms();
            return freeRooms;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Room addNewOne(Room entity) throws Exception {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Room getOneById(Long id) throws Exception {
        try {
            return repository.getReferenceById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Room updateOne(Room entity, Long id) throws Exception {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void deleteOne(Long id) {
        repository.deleteById(id);
    }

}