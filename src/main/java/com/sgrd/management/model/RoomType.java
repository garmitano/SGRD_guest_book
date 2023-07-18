package com.sgrd.management.model;

import java.util.ArrayList;
import java.util.List;

import com.sgrd.management.model.Enum.RoomTypeEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode
@Table(name = "tipos_de_habitacion")
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoomType;
    @Column(length = 10, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RoomTypeEnum type;
    @Column(length = 8, nullable = false)
    private double price;
    @Column(length = 45)
    private String detail;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms = new ArrayList<Room>();

    public RoomType(RoomTypeEnum type, double price) {
        this.type = type;
        this.price = price;
    }

    public Long getIdRoomType() {
        return idRoomType;
    }

    public RoomTypeEnum getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getDetail() {
        return detail;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setIdRoomType(Long idRoomType) {
        this.idRoomType = idRoomType;
    }

    public void setType(RoomTypeEnum type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return type.name();
    }
}