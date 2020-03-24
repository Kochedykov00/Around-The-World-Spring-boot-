package com.example.myfirstspringproject.controllers;

import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.service.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/articles")

public class ArticleController {


    @Autowired
    ArticleServiceImpl articleService;


    @PreAuthorize("permitAll()")
    @GetMapping
    public String getArticles (Model model) {
      List<Article> articlesByDate = articleService.getTop5ArticlesByDate();
      List<Article> articlesByRating = articleService.getTop5ArticlesByRating();
        model.addAttribute("articlesByDate", articlesByDate);
        model.addAttribute("articlesByRating", articlesByRating);
        return "articles";
    }

    @GetMapping("/{article-id}")
    public String getConcreteFilm(@PathVariable("article-id") Long id, Model model) {
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);
        return "article";
    }



}
