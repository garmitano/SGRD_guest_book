package com.sgrd.management.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sgrd.management.model.Employee;
import com.sgrd.management.model.Guest;
import com.sgrd.management.model.Registry;
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

            Long idGuest = 0L;
            List<Room> listFreeRooms = roomService.listFree();
            List<Employee> listEmployees = employeeService.listAll();

            model.addAttribute("registryViewModel", registryViewModel);
            model.addAttribute("idGuest", idGuest);
            model.addAttribute("listFreeRooms", listFreeRooms);
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
        service.addNewOne(registryViewModel.getRegistry());
        // service.addDetails(registryViewModel.getListIdGuest(),
        // registryViewModel.getRegistry());
        System.out.println("ESTE ES EL NRO DE ******: ");
        return "redirect:/registries";
    }

    @GetMapping("/registries/create_registry2")
    public String showFormNewRegistry2(Model model) throws Exception {
        model.addAttribute("listRegistries", service.listAll());
        return "/registries/create_registry2";
    }

    @GetMapping("/registries/new/new{id}")
    public ResponseEntity<Map<String, Object>> consultarDatos(@RequestParam("id") Integer id) {

        // ... Lógica para consultar los datos y preparar la respuesta como un objeto
        // JSON
        boolean isExtist = false;
        Map<String, Object> datos = new HashMap<>();

        Guest currentGuest = guestService.getGuestByDni(id);

        if (currentGuest != null) {
            isExtist = true;
            datos.put("fullName", currentGuest.getFullName());
            datos.put("town", currentGuest.getTown());
        }

        datos.put("isExist", isExtist);
        datos.put("id", id);
        // Devuelve la respuesta al cliente como un objeto JSON
        return ResponseEntity.ok(datos);
    }
}
