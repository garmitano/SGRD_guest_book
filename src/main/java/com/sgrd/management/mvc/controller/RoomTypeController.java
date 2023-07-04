package com.sgrd.management.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sgrd.management.model.RoomType;
import com.sgrd.management.service.implementation.IRoomTypeService;

@Controller
public class RoomTypeController {

    @Autowired
    private IRoomTypeService service;

    @GetMapping("/rooms/type")
    public String listAllRoomTypes(Model model) {
        model.addAttribute("listRoomTypes", service.listAllRoomTypes());
        return "/rooms/room_types";
    }

    @GetMapping("/rooms/type/new")
    public String showFormNewRoom(Model model) {
        RoomType roomType = new RoomType();
        model.addAttribute("roomType", roomType);
        return "/rooms/create_room_types";
    }

    @PostMapping("/rooms/type/save")
    public String saveRoomType(@ModelAttribute("roomType") RoomType roomType) {
        service.addNewRoomType(roomType);
        return "redirect:/rooms/type";
    }

    // @GetMapping("/rooms/update/{id}")
    // public String showFormNewRoom(@PathVariable Long id, Model model) {
    // model.addAttribute("room", service.getRoomById(id));
    // return "rooms/update_room";
    // }

    // @PostMapping("/rooms/{id}")
    // public String updateRoom(@PathVariable Long id, @ModelAttribute("room") Room
    // room, Model model) {
    // Room currentRoom = service.getRoomById(id);
    // currentRoom.setIdRoom(id);
    // currentRoom.setNro_room(room.getNro_room());
    // currentRoom.setState(room.getState());
    // currentRoom.setDetail(room.getDetail());
    // service.updateRoom(currentRoom);
    // return "redirect:/rooms";
    // }

    @GetMapping("/rooms/type/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        service.deleteRoomType(id);
        return "redirect:/rooms/type";
    }
}