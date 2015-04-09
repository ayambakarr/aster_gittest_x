package com.mitrais.research.springhibernate.model;

import org.hibernate.annotations.Index;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Gama Ogi Prayogo
 */
@Entity
@Table(name="people")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable {
    @Id
    @GeneratedValue
    @Column (name="id", unique = true, nullable = false)
    private Long id;
    @Column (name="full_name", length = 50)
    @Index  (name="idx_fullname")
    private String fullName;
    @Column (name="date_of_birth")
    private Date dateOfBirth;
    @Column (name="place_of_birth", length = 50)
    private String placeOfBirth;
    @Column (name="gender", length = 1)
    private String gender;
    @Column (name="nationality", length = 100)
    private String nationality;
    @Column (name="create_date")
    private Timestamp createDate;
    @Column (name="last_update")
    private Date lastUpdate;
    @Column (name="image_profile_path", length = 50)
    private String imageProfilePath;

    @OneToOne (fetch   = FetchType.EAGER,
               cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(fetch = FetchType.EAGER,
               cascade = CascadeType.ALL)
    @JoinColumn(name="person_id")
    private List<Phone> phones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getImageProfilePath() {
        return imageProfilePath;
    }

    public void setImageProfilePath(String imageProfilePath) {
        this.imageProfilePath = imageProfilePath;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}