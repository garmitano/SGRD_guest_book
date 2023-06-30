package com.sgrd.management.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.sgrd.management.model.Person;
import com.sgrd.management.service.implementation.IPersonService;

@Controller
public class PersonController {

    @Autowired
    private IPersonService service;

    @GetMapping("/persons")
    public String listAllPersons(Model model) {
        model.addAttribute("listPersons", service.listAllPersons());
        return "./persons/persons";
    }

    @GetMapping("/persons/new")
    public String addPerson(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "./persons/create_person";
    }

    @PostMapping("/persons/save")
    public String savePerson(@ModelAttribute("person") Person person) {
        service.addNewPerson(person);
        return "redirect:/persons";
    }

    @GetMapping("/persons/update/{id}")
    public String showFormUpdatePerson(@PathVariable Long id, Model model) {
        model.addAttribute("person", service.getPersonById(id));
        return "/persons/update_person";
    }

    @PostMapping("/persons/{id}")
    public String updatePerson(@PathVariable Long id, @ModelAttribute("person") Person person, Model model) {
        Person currentPerson = service.getPersonById(id);
        currentPerson.setIdPerson(id);
        currentPerson.setDni(person.getDni());
        currentPerson.setFullName(person.getFullName());
        currentPerson.setTown(person.getTown());
        service.updatePerson(currentPerson);
        return "redirect:/persons";
    }

    @GetMapping("/persons/{id}")
    public String deletePerson(@PathVariable Long id) {
        service.deletePerson(id);
        return "redirect:/persons";
    }
}
