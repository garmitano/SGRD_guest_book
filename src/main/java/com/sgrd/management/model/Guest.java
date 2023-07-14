package com.sgrd.management.model;

import com.sgrd.management.model.Enum.GuestTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
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
@Table(name = "PASAJEROS")
@PrimaryKeyJoinColumn(referencedColumnName = "idPerson")
public class Guest extends Person {

    @Column(length = 30, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private GuestTypeEnum type;
    @Column(length = 100)
    private String detail;
}