package com.sgrd.management.service.implementation;

import java.util.List;

import com.sgrd.management.model.Guest;

public interface IGuestService {
    public List<Guest> listAllGuests();

    public Guest addNewGuest(Guest guest);

    public Guest getGuestById(Long id);

    public Guest getGuestByDni(Integer id);

    public Guest updateGuest(Guest guest);

    public void deleteGuest(Long id);
}
