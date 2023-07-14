package com.sgrd.management.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

    @OneToOne(mappedBy = "registry", cascade = CascadeType.REMOVE)
    @JoinColumn(name = "fk_room")
    private Room room;

    @OneToOne(mappedBy = "registry", cascade = CascadeType.REMOVE)
    @JoinColumn(name = "fk_employee")
    private Employee employee;

    @Temporal(TemporalType.DATE)
    private LocalDate checkout;

    // @OneToOne(mappedBy = "regitry")
    // private GuestType guestType;

    // @OneToMany(mappedBy = "registry")
    // private List<Payment> payment;

    @Column(length = 8)
    private String numTicket;
}