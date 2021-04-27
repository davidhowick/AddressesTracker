package com.accela.java.model.ports;

import com.accela.java.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface AddressInfoRepo extends JpaRepository<Address, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update address set address.street = ?1, address.city = ?2, address.state = ?3, address.postal_code = ?4 where address.id = ?5", nativeQuery = true)
    void editAddressInfoByPersonsId(String street, String city, String state, String postalCode, Long id);
}
