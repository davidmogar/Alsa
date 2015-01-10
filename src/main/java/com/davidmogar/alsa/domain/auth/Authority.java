package com.davidmogar.alsa.domain.auth;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Authority {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 20, unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "authority", cascade = CascadeType.ALL)
    private Set<User> users;

    public Authority() {
    }

    public Authority(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
