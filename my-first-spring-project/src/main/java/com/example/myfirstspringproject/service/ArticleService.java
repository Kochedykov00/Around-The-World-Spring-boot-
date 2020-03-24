package com.example.myfirstspringproject.service;

import com.example.myfirstspringproject.models.Article;

import java.util.List;

public interface ArticleService {

    public List<Article> getArticles ();
    public Article getArticleById (long id);

}
