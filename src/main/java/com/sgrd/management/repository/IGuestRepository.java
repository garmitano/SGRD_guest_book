package com.sgrd.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgrd.management.model.Guest;

public interface IGuestRepository extends JpaRepository<Guest, Long> {

    @Query(value = "select pa.id_person, pa.detail, pa.type, e1_1.birthdate,e1_1.country,e1_1.dni,e1_1.email,e1_1.full_name,e1_1.phone,e1_1.province,e1_1.town from pasajeros pa JOIN personas e1_1 on e1_1.id_person = pa.id_person WHERE e1_1.dni = :dni", nativeQuery = true)
    Optional<Guest> getGuestByDni(@Param("dni") Integer dni);
    // TODO ver como castear el string del dni a int
}
