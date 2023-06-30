package com.sgrd.management.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "REGISTRO_DE_PASAJEROS")
public class Registry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistry;
    @Temporal(TemporalType.DATE)
    private LocalDate checkin;
    private Long idRoom;
    @Temporal(TemporalType.DATE)
    private LocalDate checkout;
    private Long idGuestType;
    private Long idEmployee;
    private Long idPayment;
    @Column(length = 8)
    private String numTicket;
}