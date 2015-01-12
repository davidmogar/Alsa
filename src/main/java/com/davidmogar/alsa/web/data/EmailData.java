package com.davidmogar.alsa.web.data;

import com.davidmogar.alsa.web.validation.annotations.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class EmailData {

    @NotEmpty
    @Email
    private String emailAddress;

    @NotEmpty
    private String text;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
