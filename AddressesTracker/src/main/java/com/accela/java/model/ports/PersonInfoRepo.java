package com.accela.java.model.ports;

import com.accela.java.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface PersonInfoRepo extends JpaRepository<Person, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update person set person.first_name = ?1, person.last_name = ?2 where person.id = ?3", nativeQuery = true)
    void setPersonInfoById(String firstName, String lastName, Long id);
}
