package com.davidmogar.alsa.services.news;

import com.davidmogar.alsa.dto.news.NewsDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NewsService {

    List<NewsDto> findLastFiveNews();

    Page<NewsDto> findAll(int page);

    void save(NewsDto newsDto);

}
