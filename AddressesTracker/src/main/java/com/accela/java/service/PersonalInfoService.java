package com.accela.java.service;

import com.accela.java.model.Address;
import com.accela.java.model.Person;
import com.accela.java.model.ports.AddressInfoRepo;
import com.accela.java.model.ports.PersonInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalInfoService {

    @Autowired
    PersonInfoRepo personInfoRepo;

    @Autowired
    AddressInfoRepo addressInfoRepo;


    public List<Person> list(){
        return personInfoRepo.findAll();
    }

    public void deletePerson(Long id){
        personInfoRepo.delete(id);
    }

    public int peopleCount(){
        return personInfoRepo.findAll().size();
    }

    public void addPerson(Person person){
        personInfoRepo.save(person);
    }

    public Person findPerson(Long id){
        return personInfoRepo.findOne(id);
    }

    public void deleteAllPersons(){
        personInfoRepo.deleteAll();
    }

    public void editPersonDetails(Person person){
        personInfoRepo.setPersonInfoById(person.getFirstName(), person.getLastName(), person.getId());
    }

    public void addAddress(Address address){
        addressInfoRepo.save(address);
    }

    public void editAddressDetailsOfPerson(Address address){
        addressInfoRepo.editAddressInfoByPersonsId(address.getStreet(), address.getCity(), address.getState(), address.getPostalCode(),address.getId());
    }

    public void deleteAddress(Long id){
        addressInfoRepo.delete(id);
    }
}
