package com.sgrd.management.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgrd.management.model.RoomType;
import com.sgrd.management.repository.IRoomTypeRepository;

@Service
public class RoomTypeServiceImpl implements IRoomTypeService {

    @Autowired
    private IRoomTypeRepository repository;

    @Override
    public List<RoomType> listAllRoomTypes() {
        return repository.findAll();
    }

    @Override
    public RoomType addNewRoomType(RoomType roomType) {
        return repository.save(roomType);
    }

    @Override
    public void deleteRoomType(Long id) {
        repository.deleteById(id);
    }

}
