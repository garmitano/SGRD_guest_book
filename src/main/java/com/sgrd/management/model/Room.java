package com.sgrd.management.model;

import java.util.ArrayList;
import java.util.List;

import com.sgrd.management.model.Enum.RoomStateEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "habitaciones")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoom;
    @Column(unique = true, nullable = false)
    private int nro_room;
    @Column
    @Enumerated(value = EnumType.STRING)
    private RoomStateEnum state;
    private String detail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_roomType")
    private RoomType type;

    @OneToMany(mappedBy = "room", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Registry> registry = new ArrayList<Registry>();

    public Room(int nro_room, RoomStateEnum state, RoomType type) {
        this.nro_room = nro_room;
        this.state = state;
        this.type = type;
    }

    public Long getIdRoom() {
        return idRoom;
    }

    public int getNro_room() {
        return nro_room;
    }

    public RoomStateEnum getState() {
        return state;
    }

    public String getDetail() {
        return detail;
    }

    public RoomType getType() {
        return type;
    }

    public List<Registry> getRegistry() {
        return registry;
    }

    public void setIdRoom(Long idRoom) {
        this.idRoom = idRoom;
    }

    public void setNro_room(int nro_room) {
        this.nro_room = nro_room;
    }

    public void setState(RoomStateEnum state) {
        this.state = state;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public void setRegistry(List<Registry> registry) {
        this.registry = registry;
    }

}