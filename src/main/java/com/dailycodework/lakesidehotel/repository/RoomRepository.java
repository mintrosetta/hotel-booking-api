package com.dailycodework.lakesidehotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodework.lakesidehotel.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    
}