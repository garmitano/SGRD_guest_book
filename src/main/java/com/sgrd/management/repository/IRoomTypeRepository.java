package com.sgrd.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrd.management.model.RoomType;

public interface IRoomTypeRepository extends JpaRepository<RoomType, Long> {

}
