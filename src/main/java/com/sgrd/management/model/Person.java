package com.sgrd.management.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
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
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;
    @Column(length = 11, nullable = false, unique = true)
    private int dni;
    @Column(length = 45, nullable = false)
    private String fullName;
    @Column(length = 35)
    private String town;
    @Column(length = 35)
    private String province;
    @Column(length = 35)
    private String country;
    @Column(length = 25)
    private String phone;
    @Column(length = 35)
    private String email;
    @Temporal(TemporalType.DATE)
    private LocalDate birthdate;

    public Person(int dni, String fullName) {
        this.dni = dni;
        this.fullName = fullName;
    }

}