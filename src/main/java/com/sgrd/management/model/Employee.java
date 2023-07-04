package com.sgrd.management.model;

import com.sgrd.management.model.Enum.EmployeeTypeEnum;

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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "EMPLEADOS")
@PrimaryKeyJoinColumn(referencedColumnName = "idPerson")
public class Employee extends Person {

    @Column(length = 100)
    @Enumerated(value = EnumType.STRING)
    private EmployeeTypeEnum type;

}