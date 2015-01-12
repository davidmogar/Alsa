package com.davidmogar.alsa.web.controllers.news;

import com.davidmogar.alsa.dto.news.NewsDto;
import com.davidmogar.alsa.services.news.NewsManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/news")
public class NewsController {

    @Autowired
    private NewsManagerService newsManagerService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createNews(Model model) {
        model.addAttribute("news", new NewsDto());

        return "admin.news.create";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listNews() {
        return listNews(1);
    }

    @RequestMapping(value = "/list/{pageIndex}", method = RequestMethod.GET)
    public ModelAndView listNewsPage(@PathVariable int pageIndex) {
        return listNews(pageIndex);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNews(@Valid @ModelAttribute NewsDto newsDto, BindingResult bindingResult) {
        String view = "admin.news.create";

        if (!bindingResult.hasErrors()) {
            newsManagerService.save(newsDto);

            view = "redirect:/admin/news/list";
        }

        return view;
    }

    private ModelAndView listNews(int pageIndex) {
        ModelAndView modelAndView = new ModelAndView("admin.news.list");

        Page<NewsDto> page = newsManagerService.findAll(pageIndex);
        modelAndView.addObject("news", page.getContent()); /* TODO: Paginate */

        return modelAndView;
    }

}
