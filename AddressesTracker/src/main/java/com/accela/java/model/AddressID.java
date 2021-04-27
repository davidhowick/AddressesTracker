package com.accela.java.model;

import java.io.Serializable;
import java.util.Objects;

public class AddressID implements Serializable {
    private Long id;
    private String postalCode;

    public AddressID(Long id, String postalCode){
        this.id = id;
        this.postalCode = postalCode;
    }

    public AddressID(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressID accountId = (AddressID) o;
        return id.equals(accountId.id) &&
                postalCode.equals(accountId.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postalCode);
    }
}
