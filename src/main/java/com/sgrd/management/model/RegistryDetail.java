package com.sgrd.management.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "detalle_de_registro")
public class RegistryDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_guest")
    private Guest guest;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_registry")
    private Registry registry;

    public RegistryDetail(Guest guest) {
        this.guest = guest;
    }

}