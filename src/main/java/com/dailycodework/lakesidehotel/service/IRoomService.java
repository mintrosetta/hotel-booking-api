package com.dailycodework.lakesidehotel.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.web.multipart.MultipartFile;

import com.dailycodework.lakesidehotel.model.Room;

public interface IRoomService {
    Room createRoom(MultipartFile photo, String roomType, BigDecimal price) throws IOException, SerialException, SQLException;
}
