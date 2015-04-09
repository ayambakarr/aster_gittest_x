package com.mitrais.research.springhibernate.model;

import javax.persistence.*;

/**
 * @author Gama Ogi Prayogo
 */
@Entity
@Table(name="addresses")
public class Address{
    @Id
    @GeneratedValue
    @Column( name ="id")
    private Integer id;
    @Column (name ="address")
    private String address;

    public Address() {}

    public Address(String address){
        this.address=address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
