package com.sgrd.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgrd.management.model.Room;

public interface IRoomRepository extends JpaRepository<Room, Long> {

    @Query(value = "SELECT * FROM habitaciones WHERE state = 'LIBRE'", nativeQuery = true)
    List<Room> freeRooms();
}