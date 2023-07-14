package com.sgrd.management.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sgrd.management.model.Guest;
import com.sgrd.management.service.implementation.IGuestService;

@Controller
public class GuestController {

    @Autowired
    private IGuestService service;

    @GetMapping("/guests")
    public String listAllGuests(Model model) {
        model.addAttribute("listGuests", service.listAllGuests());
        return "./guests/guests";
    }

    @GetMapping("/guests/new")
    public String showFormNewGuest(Model model) {
        Guest guest = new Guest();
        model.addAttribute("guest", guest);
        return "./guests/create_guest";
    }

    @PostMapping("/guests/save")
    public String saveGuest(@ModelAttribute("guest") Guest guest) {
        service.addNewGuest(guest);
        return "redirect:/guests";
    }

    @GetMapping("/guests/update/{id}")
    public String showFormUpdateGuest(@PathVariable Long id, Model model) {
        model.addAttribute("guest", service.getGuestById(id));
        return "/guests/update_guest";
    }

    @PostMapping("/guests/{id}")
    public String updatePerson(@PathVariable Long id, @ModelAttribute("guest") Guest guest, Model model) {
        Guest currentGuest = service.getGuestById(id);
        currentGuest.setIdPerson(id);
        currentGuest.setDni(guest.getDni());
        currentGuest.setFullName(guest.getFullName());
        currentGuest.setTown(guest.getTown());
        currentGuest.setProvince(guest.getProvince());
        currentGuest.setCountry(guest.getCountry());
        currentGuest.setPhone(guest.getPhone());
        currentGuest.setEmail(guest.getEmail());
        currentGuest.setBirthdate(guest.getBirthdate());
        currentGuest.setType(guest.getType());
        currentGuest.setDetail(guest.getDetail());
        service.updateGuest(currentGuest);
        return "redirect:/guests";
    }

    @GetMapping("/guests/info/{id}")
    public String showFormUpdatePerson(@PathVariable Long id, Model model) {
        model.addAttribute("guest", service.getGuestById(id));
        return "/guests/info_guest";
    }

    @GetMapping("/guests/delete/{id}")
    public String deleteGuest(@PathVariable Long id) {
        service.deleteGuest(id);
        return "redirect:/guests";
    }
}
