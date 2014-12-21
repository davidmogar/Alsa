package com.davidmogar.alsa.dto.auth;

import com.davidmogar.alsa.domain.auth.Authority;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AuthorityDto {

    private Long id;

    @NotNull
    @Size(min = 6, max = 20)
    private String name;

    @Size(max = 255)
    private String description;

    public AuthorityDto() {
    }

    public AuthorityDto(Authority authority) {
        id = authority.getId();
        name = authority.getName();
        description = authority.getDescription();
    }

    @Override
    public String toString() {
        return name;
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

}
