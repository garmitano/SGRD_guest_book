package com.sgrd.management.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sgrd.management.model.Room;
import com.sgrd.management.model.RoomType;
import com.sgrd.management.service.implementation.IRoomTypeService;
import com.sgrd.management.service.implementation.RoomServiceImpl;

@Controller
public class RoomController {

    @Autowired
    private RoomServiceImpl service;

    @Autowired
    private IRoomTypeService typeService;

    @GetMapping("/rooms")
    public String listAllRooms(Model model) throws Exception {
        try {
            model.addAttribute("listRooms", service.listAll());
            return "rooms/rooms";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/rooms/new")
    public String showFormNewRoom(Model model) throws Exception {
        try {
            Room room = new Room();
            List<RoomType> listRoomTypes = typeService.listAllRoomTypes();

            model.addAttribute("room", room);
            model.addAttribute("listRoomTypes", listRoomTypes);
            return "rooms/create_room";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/rooms/save")
    public String savePerson(@ModelAttribute("room") Room room, Model model) throws Exception {
        try {
            service.addNewOne(room);
            return "redirect:/rooms";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/rooms/update/{id}")
    public String showFormNewRoom(@PathVariable Long id, Model model) throws Exception {
        try {
            model.addAttribute("room", service.getOneById(id));
            return "rooms/update_room";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/rooms/{id}")
    public String updateRoom(@PathVariable Long id, @ModelAttribute("room") Room room, Model model) throws Exception {
        try {
            Room currentRoom = service.getOneById(id);
            currentRoom.setIdRoom(id);
            currentRoom.setNro_room(room.getNro_room());
            currentRoom.setState(room.getState());
            currentRoom.setDetail(room.getDetail());
            service.updateOne(currentRoom, id);
            return "redirect:/rooms";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/rooms/delete/{id}")
    public String deleteRoom(@PathVariable Long id, Model model) throws Exception {
        try {
            service.deleteOne(id);
            return "redirect:/rooms";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}