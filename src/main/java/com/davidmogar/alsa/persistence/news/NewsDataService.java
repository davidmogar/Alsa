package com.davidmogar.alsa.persistence.news;

import com.davidmogar.alsa.domain.news.News;
import com.davidmogar.alsa.dto.news.NewsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsDataService {

    Page<News> findAll(Pageable pageable);

    List<News> findFirst5ByOrderByPublicationDateDesc();

    News save(News news);

}
