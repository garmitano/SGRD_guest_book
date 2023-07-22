package com.sgrd.management.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sgrd.management.model.Employee;
import com.sgrd.management.model.Guest;
import com.sgrd.management.model.Registry;
import com.sgrd.management.model.RegistryDetail;
import com.sgrd.management.model.Room;
import com.sgrd.management.mvc.view.RegistryViewModel;
import com.sgrd.management.service.implementation.EmployeeServiceImpl;
import com.sgrd.management.service.implementation.GuestServiceImpl;
import com.sgrd.management.service.implementation.RegistryServiceImpl;
import com.sgrd.management.service.implementation.RoomServiceImpl;

@Controller
public class RegistryController {
    @Autowired
    private RegistryServiceImpl service;
    @Autowired
    private RoomServiceImpl roomService;
    @Autowired
    private GuestServiceImpl guestService;
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/registries")
    public String listAllRegistries(Model model) throws Exception {
        model.addAttribute("listRegistries", service.listAll());
        return "/registries/registries";
    }

    @GetMapping("/registries/new")
    public String showFormNewRegistry(Model model) throws Exception {
        try {
            RegistryViewModel registryViewModel = new RegistryViewModel();
            registryViewModel.setRegistry(new Registry());
            registryViewModel.setListIdGuest(new ArrayList<Long>());

            List<Guest> listGuests = guestService.listAllGuests();
            List<Room> listRooms = roomService.listAll();
            List<Employee> listEmployees = employeeService.listAll();

            model.addAttribute("registryViewModel", registryViewModel);
            model.addAttribute("listGuests", listGuests);
            model.addAttribute("listRooms", listRooms);
            model.addAttribute("listEmployees", listEmployees);
            return "registries/create_registry";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/registries/save")
    public String saveRegistry(@ModelAttribute("registryViewModel") RegistryViewModel registryViewModel)
            throws Exception {
        // Procesar la información del registro y su detalle
        // Guardar en la base de datos, realizar cálculos, etc.
        service.addNewOne(registryViewModel.getRegistry());
        // ver como guardar el listado de guest sacado de la viewModel y puesto en
        // registryDetail
        service.addDetails(registryViewModel.getListIdGuest(), registryViewModel.getRegistry());

        return "redirect:/registries";
    }
}
