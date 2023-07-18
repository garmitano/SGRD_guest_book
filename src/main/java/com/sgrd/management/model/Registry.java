package com.sgrd.management.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "registro_de_pasajeros")
public class Registry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistry;

    @Temporal(TemporalType.DATE)
    private LocalDate checkin;

    @Temporal(TemporalType.DATE)
    private LocalDate checkout;

    @Column(length = 8)
    private String numTicket;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_room")
    private Room room;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_employee")
    private Employee employee;

    @OneToMany(mappedBy = "registry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistryDetail> registryDetails = new ArrayList<RegistryDetail>();

}