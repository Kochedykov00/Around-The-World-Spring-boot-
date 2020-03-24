package com.example.myfirstspringproject.service;

import com.example.myfirstspringproject.dto.ArticleDto;
import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.ArticlesRepository;
import com.example.myfirstspringproject.util.FileStorageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    ArticlesRepository articlesRepository;

    @Autowired
    FileStorageUtil fileStorageUtil;


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

    public void createArticle(ArticleDto articleDto, User user) {
        Date date = new Date();
        Article article = Article.builder()
                .date(date)
                .rating(0)
                .text(articleDto.getText())
                .title(articleDto.getTitle())
                .user(user)
                .photo(articleDto.getPhoto())
                .build();
        articlesRepository.save(article);
    }

}
