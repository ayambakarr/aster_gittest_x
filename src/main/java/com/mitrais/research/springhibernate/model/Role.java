package com.mitrais.research.springhibernate.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Gama Ogi Prayogo
 */
@Entity
@Table(name = "user_roles")
public class Role implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name="description")
    private String description;

    @Column(name="role_name")
    private String roleName;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
