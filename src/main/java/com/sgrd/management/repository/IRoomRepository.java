package com.sgrd.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrd.management.model.Room;

public interface IRoomRepository extends JpaRepository<Room, Long> {

}
