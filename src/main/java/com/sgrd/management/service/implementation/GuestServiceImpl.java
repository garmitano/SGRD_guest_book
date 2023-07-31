package com.sgrd.management.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgrd.management.model.Guest;
import com.sgrd.management.repository.IGuestRepository;

@Service
public class GuestServiceImpl implements IGuestService {

    @Autowired
    private IGuestRepository repository;

    @Override
    public List<Guest> listAllGuests() {
        return repository.findAll();
    }

    @Override
    public Guest addNewGuest(Guest guest) {
        return repository.save(guest);
    }

    @Override
    public Guest getGuestById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Guest updateGuest(Guest guest) {
        return repository.save(guest);
    }

    @Override
    public void deleteGuest(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Guest getGuestByDni(Integer id) {
        Optional<Guest> guestOptional = repository.getGuestByDni(id);
        return guestOptional.orElse(null);
    }

}
