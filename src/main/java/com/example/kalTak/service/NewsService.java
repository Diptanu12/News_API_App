package com.example.kalTak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    @Autowired
    RestTemplate restTemplate;

    String baseUrl = "https://newsapi.org/v2/top-headlines";

    public Object getNews(String source, String api) {
        try {
            String url = prepareUrl(source, api);
            return restTemplate.getForObject(url, Object.class);
        } catch (RestClientException e) {
            return "Error fetching news: " + e.getMessage();
        }
    }

    private String prepareUrl(String source, String api) {
        return baseUrl + "?sources=" + source + "&apiKey=" + api;
    }
}
