package com.sgrd.management.model;

import com.sgrd.management.model.Enum.GuestTypeEnum;

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
@Table(name = "tipos_de_pasajeros")
public class GuestType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGuestType;
    @Column(length = 30, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private GuestTypeEnum type;
    @Column(length = 100)
    private String detail;

}