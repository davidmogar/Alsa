package com.davidmogar.alsa.services.news.internal;

import com.davidmogar.alsa.domain.change.DatabaseChange;
import com.davidmogar.alsa.domain.news.News;
import com.davidmogar.alsa.dto.news.NewsDto;
import com.davidmogar.alsa.persistence.change.DatabaseChangeDataService;
import com.davidmogar.alsa.persistence.news.NewsDataService;
import com.davidmogar.alsa.services.news.NewsManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NewsManagerServiceImpl implements NewsManagerService {

    protected static final int NUMBER_OF_NEWS_PER_PAGE = 10;

    @Autowired
    private DatabaseChangeDataService databaseChangeDataService;

    @Autowired
    private NewsDataService newsDataService;

    @Override
    public List<NewsDto> findLastFiveNews() {
        return StreamSupport.stream(newsDataService.findFirst5ByOrderByPublicationDateDesc().spliterator(), false)
                .map(NewsDto::new).collect(Collectors.toList());
    }

    @Override
    public Page<NewsDto> findAll(int pageIndex) {
        Pageable pageable = createPageable(pageIndex);
        Page<News> page = newsDataService.findAll(pageable);

        List<NewsDto> news = page.getContent().stream().map(NewsDto::new).collect(Collectors.toList());

        return new PageImpl<>(news, pageable, page.getTotalElements());
    }

    @Override
    public void save(NewsDto newsDto) {
        News news = new News(newsDto.getTitle(), newsDto.getText(), newsDto.getPublicationDate());

        newsDataService.save(news);

        databaseChangeDataService.save(new DatabaseChange("Created news with title " + newsDto.getTitle()));
    }

    /**
     * Creates a new Pageable object. PageIndex should be a value starting at 1.
     *
     * @param pageIndex index of the desired page.
     * @return new Pageable object.
     */
    private Pageable createPageable(int pageIndex) {
        return new PageRequest(pageIndex - 1, NUMBER_OF_NEWS_PER_PAGE, new Sort(Sort.Direction.DESC, "publicationDate"));
    }

}
