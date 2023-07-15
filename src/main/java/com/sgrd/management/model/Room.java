package com.sgrd.management.model;

import com.sgrd.management.model.Enum.RoomStateEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "HABITACIONES")
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

    @ManyToOne
    @JoinColumn(name = "fk_roomType")
    private RoomType type;

    @OneToOne(mappedBy = "room")
    private Registry registry;

    public Room(int nro_room, RoomStateEnum state, String detail) {
        this.nro_room = nro_room;
        this.state = state;
        this.detail = detail;
    }

}