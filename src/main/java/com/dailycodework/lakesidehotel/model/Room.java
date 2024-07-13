package com.dailycodework.lakesidehotel.model;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "is_booked")
    private Boolean isBooked = false;

    @OneToMany(mappedBy = "room")
    private List<BookRoom> bookings;

    @Lob
    private Blob photo;

    public Room() {
        this.bookings = new ArrayList<>();
    }

    public Room(String roomType, BigDecimal price, Boolean isBooked, List<BookRoom> bookings) {
        this.roomType = roomType;
        this.price = price;
        this.isBooked = isBooked;
        this.bookings = bookings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(Boolean isBooked) {
        this.isBooked = isBooked;
    }

    public List<BookRoom> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookRoom> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(BookRoom booking) {
        if (this.bookings == null) {
            this.bookings = new ArrayList<>();
        }

        this.bookings.add(booking);
        booking.setRoom(this);
        this.isBooked = true;
        String bookingCode = RandomStringUtils.randomNumeric(10);
        booking.setBookingConfirmationCode(bookingCode);
    }
}
