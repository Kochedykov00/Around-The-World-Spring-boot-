package com.example.myfirstspringproject.service;

import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    ArticlesRepository articlesRepository;


    public List<Article> getArticles () {
        List<Article> articles = articlesRepository.findAll();
        return articles;
    }

    public Article getArticleById (long id) {
        Article article = articlesRepository.findArticleById(id);
        return article;
    }

    public List<Article> getTop5ArticlesByDate() {
        List<Article> articles = articlesRepository.findTop5ArticlesByDate();
        return articles;
    }

    public List<Article> getTop5ArticlesByRating() {
        List<Article> articles = articlesRepository.findTop5ArticlesByRating();
        return articles;
    }

}
