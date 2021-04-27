package com.accela.java.controllers;

import com.accela.java.service.PersonalInfoService;
import com.accela.java.model.Address;
import com.accela.java.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api", method = {RequestMethod.GET, RequestMethod.DELETE})
public class PersonProfileController {

    @Autowired
    private PersonalInfoService personalInfoService;

    @PostMapping(value = "/people/add", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void addPerson(@RequestBody Person person){
        personalInfoService.addPerson(person);
    }

    @PostMapping(value = "/people/update", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void updatePerson(@RequestBody Person person){
        personalInfoService.editPersonDetails(person);
    }

    @DeleteMapping("/people/remove/{id}")
    public void deletePerson(@PathVariable Long id){
        personalInfoService.deletePerson(id);
    }

    @GetMapping("/people/count")
    public int getTheNumberOfPeople(){
        return personalInfoService.peopleCount();
    }

    @GetMapping("/people/list")
    public List<Person> getListOfPeopleInDb(){
        return personalInfoService.list();
    }

    @PostMapping(value="/address/add", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void addAddress(@RequestBody Address address){
        personalInfoService.addAddress(address);
    }

    @DeleteMapping("/address/remove/{id}")
    public void deletePersonsAddress(@PathVariable Long id){
        personalInfoService.deleteAddress(id);
    }

    @PostMapping(value = "/address/update", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void updatePersonsAddress(@RequestBody Address address){
        personalInfoService.editAddressDetailsOfPerson(address);
    }
}
