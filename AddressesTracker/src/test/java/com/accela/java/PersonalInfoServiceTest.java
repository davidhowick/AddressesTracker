package com.accela.java;

import com.accela.java.model.Person;
import com.accela.java.service.PersonalInfoService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/scripts/INIT_TWO_PERSONS.sql")
public class PersonalInfoServiceTest {

    @Autowired
    PersonalInfoService personalInfoService;

    @Test
    public void checkDBOperations(){
        checkThatWhenTheApplicationStartsTheSetupInsertsAreFoundInTheDB();
        checkThatPersonsDetailsAreEdited();
        checkThatTheTargetedIdToBeDeletedIsRemovedFromTheDb();
        checkThatPersonIsAddedToThePersonTable();
    }

    public void checkThatWhenTheApplicationStartsTheSetupInsertsAreFoundInTheDB(){
        List<Person> person = personalInfoService.list();

        Assert.assertEquals(2, person.size());
    }

    @Ignore
    public void checkThatTheTargetedIdToBeDeletedIsRemovedFromTheDb(){
        personalInfoService.deletePerson((long) 1);
        List<Person> person = personalInfoService.list();

        Assert.assertEquals(1, person.size());
    }

    public void checkThatPersonIsAddedToThePersonTable(){
        Person person = new Person();
        person.setFirstName("Mary");
        person.setLastName("Burke");

        personalInfoService.addPerson(person);
        Person personFound = personalInfoService.findPerson((long) 3);

        Assert.assertEquals("The person found in the person table was not who was expected",
                "Mary " + "Burke", personFound.getFirstName() + " " + personFound.getLastName());
    }

    public void checkThatPersonsDetailsAreEdited() {
        Person person = mock(Person.class);
        when(person.getFirstName()).thenReturn("Mary");
        when(person.getLastName()).thenReturn("Malone");
        when(person.getId()).thenReturn((long) 1);

        personalInfoService.editPersonDetails(person);
        Person personFound = personalInfoService.findPerson((long) 1);

        Assert.assertEquals("The record was not update as expected", "Mary Malone",
                personFound.getFirstName() + " " + personFound.getLastName());
    }
}
