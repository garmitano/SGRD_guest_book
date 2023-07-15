package com.sgrd.management.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sgrd.management.model.Registry;
import com.sgrd.management.model.Room;
import com.sgrd.management.service.implementation.RegistryServiceImpl;
import com.sgrd.management.service.implementation.RoomServiceImpl;

@Controller
public class RegistryController {
    @Autowired
    private RegistryServiceImpl service;
    @Autowired
    private RoomServiceImpl roomService;

    @GetMapping("/registries")
    public String listAllRegistries(Model model) throws Exception {
        model.addAttribute("listRegistries", service.listAll());
        return "/registries/registries";
    }

    @GetMapping("/registries/new")
    public String showFormNewRegistry(Model model) throws Exception {
        try {
            Registry registry = new Registry();
            List<Room> listRooms = roomService.listAll();

            model.addAttribute("registry", registry);
            model.addAttribute("listRooms", listRooms);
            return "registries/create_registry";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "";
        }
    }

    @PostMapping("/registries/save")
    public String saveRegistry(@ModelAttribute("registry") Registry registry) throws Exception {
        service.addNewOne(registry);
        return "redirect:/registries";
    }
}
