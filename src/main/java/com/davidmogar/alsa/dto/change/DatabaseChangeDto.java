package com.davidmogar.alsa.dto.change;

import com.davidmogar.alsa.domain.change.DatabaseChange;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class DatabaseChangeDto {

    @NotNull
    private Date date;

    @NotNull
    @Size(max = 255)
    private String text;

    public DatabaseChangeDto() {
    }

    public DatabaseChangeDto(DatabaseChange change) {
        date = change.getDate();
        text = change.getText();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
