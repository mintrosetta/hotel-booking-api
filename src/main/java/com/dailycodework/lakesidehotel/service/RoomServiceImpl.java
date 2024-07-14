package com.dailycodework.lakesidehotel.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dailycodework.lakesidehotel.model.Room;
import com.dailycodework.lakesidehotel.repository.RoomRepository;

@Service
public class RoomServiceImpl implements IRoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room createRoom(MultipartFile file, String roomType, BigDecimal price) throws IOException, SerialException, SQLException {
        Room room = new Room();
        room.setRoomType(roomType);
        room.setPrice(price);
        
        if (!file.isEmpty()) {
            byte[] photoByte = file.getBytes();
            Blob photoBlob = new SerialBlob(photoByte); // convert byte to blob
            room.setPhoto(photoBlob);
        }

        this.roomRepository.save(room);
        
        return room;
    }

}
