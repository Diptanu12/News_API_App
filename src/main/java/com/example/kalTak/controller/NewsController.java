package com.example.kalTak.controller;


import com.example.kalTak.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/news")
public class NewsController {
    @Autowired
    private NewsService newsService;


    @GetMapping
    public Object getNews(@RequestParam("sources") String sources
            , @RequestParam("apiKey") String apiKey) {
        return newsService.getNews(sources, apiKey);
    }
}
