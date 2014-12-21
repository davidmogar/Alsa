package com.davidmogar.alsa.domain.auth;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean enabled;

    @ManyToOne
    @JoinColumn
    private Authority authority;

    public static Builder getBuilder(String username, String password, boolean enabled) {
        return new Builder(username, password, enabled);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public static class Builder {
        User built;

        Builder(String username, String password, boolean enabled) {
            built = new User();
            built.username = username;
            built.password = password;
            built.enabled = enabled;
        }

        public Builder firstname(String firstname) {
            built.firstname = firstname;

            return this;
        }

        public Builder lastname(String lastname) {
            built.lastname = lastname;

            return this;
        }

        public Builder email(String email) {
            built.email = email;

            return this;
        }

        public Builder authority(Authority authority) {
            built.authority = authority;

            return this;
        }

        public User build() {
            return built;
        }

    }
}
