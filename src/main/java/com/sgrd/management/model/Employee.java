package com.sgrd.management.model;

import java.util.ArrayList;
import java.util.List;

import com.sgrd.management.model.Enum.EmployeeTypeEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "empleados")
@PrimaryKeyJoinColumn(referencedColumnName = "idPerson")
public class Employee extends Person {

    @Column(length = 100)
    @Enumerated(value = EnumType.STRING)
    private EmployeeTypeEnum type;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Registry> registry = new ArrayList<Registry>();

    public Employee(int dni, String fullName, EmployeeTypeEnum type) {
        super(dni, fullName);
        this.type = type;
    }

}