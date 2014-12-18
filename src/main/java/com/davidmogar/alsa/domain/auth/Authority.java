package com.davidmogar.alsa.domain.auth;

import com.davidmogar.alsa.domain.auth.User;

import javax.persistence.*;

@Entity
public class Authority {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String authority;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
