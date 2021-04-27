package com.accela.java.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="address")
@IdClass(AddressID.class)
public class Address implements Serializable {

    @Id
    private Long id;

    @NotNull
    @Column(name = "street")
    private String street;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "state")
    private String state;

    @NotNull
    @Id
    @Column(name = "postal_code")
    private String postalCode;

    public Address(){}

    public Long getId(){
        return this.id;
    }

    public String getCity(){
        return this.city;
    }

    public String getStreet(){
        return this.street;
    }

    public String getState(){
        return this.state;
    }

    public String getPostalCode(){
        return this.postalCode;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }
}
