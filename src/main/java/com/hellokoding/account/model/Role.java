package com.hellokoding.account.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
//@SequenceGenerator(name="role_seq", sequenceName="role_sequence")
public class Role {
    private String id;
    private String name;
    private Set<User> users;

    @Id
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="role_seq")
    @GenericGenerator(name = "role-uuid", strategy = "uuid")
    @GeneratedValue(generator = "role-uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
