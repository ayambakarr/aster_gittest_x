package com.mitrais.research.springhibernate.model;


import org.hibernate.annotations.Index;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Gama Ogi Prayogo
 */
@Entity
@Table(name = "users")
@PrimaryKeyJoinColumn(name = "person_id")
public class User extends Person {
    @Column(name = "username", unique = true, length = 20)
    @Index(name = "idx_username")
    private String username;

    @Column(name = "password", length = 32)
    private String password;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "last_login")
    private Date lastLogin;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "username")
//    @JoinTable(name = "user_has_roles")
//    private List<Role> roles;

    public User() {
    }

    public User(String fullName, String username, String password, String email, Date dateOfBirth) {
        super.setFullName(fullName);
        this.username = username;
        this.password = password;
        this.email = email;
        super.setDateOfBirth(dateOfBirth);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return null;
    }

    public void setRoles(List<Role> roles) {
//        this.roles = roles;
    }


    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}


