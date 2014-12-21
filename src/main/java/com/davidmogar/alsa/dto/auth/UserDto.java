package com.davidmogar.alsa.dto.auth;

import com.davidmogar.alsa.domain.auth.Authority;
import com.davidmogar.alsa.domain.auth.User;
import com.davidmogar.alsa.web.validation.annotations.Email;
import com.davidmogar.alsa.web.validation.annotations.Password;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @Email
    private String email;

    @NotNull
    @Size(min = 5, max = 20)
    private String username;

    @Password
    private String password;
    private String repeatedPassword;

    @NotNull
    private String authority;

    private boolean enabled;

    public UserDto() {
        enabled = true;
    }

    public UserDto(User user) {
        if (user != null) {
            firstname = user.getFirstname();
            lastname = user.getLastname();
            email = user.getEmail();
            username = user.getUsername();
            password = user.getPassword();

            Authority authorityObject = user.getAuthority();

            if (authorityObject != null) {
                authority = authorityObject.getName();
            }

            enabled = user.isEnabled();
        }
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

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
