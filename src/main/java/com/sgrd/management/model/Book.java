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
@Table(name = "reservas")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;
    @Column(length = 8, nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate checkin;
    private Long idRoomType;
    private Long idPerson;
    private Long idGuestType;
    private Long idPayment;
    @Column(length = 15, nullable = false)
    private String state;
    // TODO ver si es campo de texto mas grande
    @Column(length = 100)
    private String detail;
}
