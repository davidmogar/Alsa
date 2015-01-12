package com.davidmogar.alsa.domain.change;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Store changes in the database derived from insertions.
 */
@Entity
public class DatabaseChange {

    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    @Column(nullable = false)
    private String text;

    public DatabaseChange() {
    }

    public DatabaseChange(String text) {
        this.text = text;

        date = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
