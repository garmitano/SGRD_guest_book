package com.sgrd.management.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    private Map<String, Object> datos = new HashMap<>();
    private List<Long> listIdGuest = new ArrayList<>();

    @Autowired
    private RegistryServiceImpl service;
    @Autowired
    private RoomServiceImpl roomService;
    @Autowired
    private GuestServiceImpl guestService;
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/registries")
    @CrossOrigin(origins = "http://localhost:8086", methods = { RequestMethod.GET, RequestMethod.POST })
    public String listAllRegistries(Model model) throws Exception {
        model.addAttribute("listRegistries", service.listAll());
        return "/registries/registries";
    }

    @GetMapping("/registries/new")
    @CrossOrigin(origins = "http://localhost:8086", methods = { RequestMethod.GET, RequestMethod.POST })
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
    @CrossOrigin(origins = "http://localhost:8086", methods = { RequestMethod.GET, RequestMethod.POST })
    public String saveRegistry(@ModelAttribute("registryViewModel") RegistryViewModel registryViewModel)
            throws Exception {
        // TODO DRY in registry
        service.addNewOne(registryViewModel.getRegistry());
        service.addDetails(listIdGuest, registryViewModel.getRegistry());

        return "redirect:/registries";
    }

    @GetMapping("/registries/new/new{dni}")
    @CrossOrigin(origins = "http://localhost:8086", methods = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<Map<String, Object>> consultarDatos(@RequestParam("dni") Integer dni) {

        boolean isExtist = false;

        Guest currentGuest = guestService.getGuestByDni(dni);

        if (currentGuest != null) {
            isExtist = true;
            listIdGuest.add(currentGuest.getIdPerson());
            datos.put("dni", dni);
            datos.put("fullName", currentGuest.getFullName());
            datos.put("town", currentGuest.getTown());
        }

        datos.put("isExist", isExtist);

        return ResponseEntity.ok(datos);
    }
}
