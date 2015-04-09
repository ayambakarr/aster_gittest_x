package com.mitrais.research.springhibernate.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Gama Ogi Prayogo
 */
@Entity
@Table(name = "phones")
public class Phone implements Serializable {

    @Id
    @GeneratedValue
    @Column (name = "id")
    private Long id;
    @Column (name= "phone_number", length = 50)
    private String phoneNumber;
    @Column (name = "label", length = 50)
    private String label;

    public Phone() {

    }

    public Phone(String label, String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.label = label;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}


