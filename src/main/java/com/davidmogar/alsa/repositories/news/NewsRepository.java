package com.davidmogar.alsa.repositories.news;

import com.davidmogar.alsa.domain.news.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findFirst5ByOrderByPublicationDateDesc();

}
