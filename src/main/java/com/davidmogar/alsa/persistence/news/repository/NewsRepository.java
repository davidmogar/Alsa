package com.davidmogar.alsa.persistence.news.repository;

import com.davidmogar.alsa.domain.news.News;
import com.davidmogar.alsa.persistence.news.NewsDataService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends NewsDataService, JpaRepository<News, Long> {

    List<News> findFirst5ByOrderByPublicationDateDesc();

}
