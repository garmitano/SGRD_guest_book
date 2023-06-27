package com.sgrd.management.model;

import com.sgrd.management.model.Enum.RoomTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "TIPOS_DE_HABITACION")
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoomType;
    @Column(length = 8, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RoomTypeEnum type;
    @Column(length = 8, nullable = false)
    private double price;
    @Column(length = 8)
    private String detail;
}