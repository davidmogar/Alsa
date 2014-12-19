package com.davidmogar.alsa.dto.news;

import com.davidmogar.alsa.domain.news.News;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.Date;

public class NewsDto {

    @NotEmpty
    @Size(max = 255)
    private String title;

    @NotEmpty
    @Size(min = 200, max = 1000)
    private String text;

    private Date publicationDate;

    public NewsDto() {
        publicationDate = new Date();
    }

    public NewsDto(News news) {
        this.title = news.getTitle();
        this.text = news.getText();
        this.publicationDate = news.getPublicationDate();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

}
