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
import com.sgrd.management.service.implementation.IRoomService;
import com.sgrd.management.service.implementation.IRoomTypeService;

@Controller
public class RoomController {

    @Autowired
    private IRoomService service;

    @Autowired
    private IRoomTypeService typeService;

    @GetMapping("/rooms")
    public String listAllRooms(Model model) {
        model.addAttribute("listRooms", service.listAllRoom());
        return "rooms/rooms";
    }

    @GetMapping("/rooms/new")
    public String showFormNewRoom(Model model) {
        Room room = new Room();
        List<RoomType> listRoomTypes = typeService.listAllRoomTypes();

        model.addAttribute("room", room);
        model.addAttribute("listRoomTypes", listRoomTypes);
        return "rooms/create_room";
    }

    @PostMapping("/rooms/save")
    public String savePerson(@ModelAttribute("room") Room room) {
        service.addNewRoom(room);
        return "redirect:/rooms";
    }

    @GetMapping("/rooms/update/{id}")
    public String showFormNewRoom(@PathVariable Long id, Model model) {
        model.addAttribute("room", service.getRoomById(id));
        return "rooms/update_room";
    }

    @PostMapping("/rooms/{id}")
    public String updateRoom(@PathVariable Long id, @ModelAttribute("room") Room room, Model model) {
        Room currentRoom = service.getRoomById(id);
        currentRoom.setIdRoom(id);
        currentRoom.setNro_room(room.getNro_room());
        currentRoom.setState(room.getState());
        currentRoom.setDetail(room.getDetail());
        service.updateRoom(currentRoom);
        return "redirect:/rooms";
    }

    @GetMapping("/rooms/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        service.deleteRoom(id);
        return "redirect:/rooms";
    }
}