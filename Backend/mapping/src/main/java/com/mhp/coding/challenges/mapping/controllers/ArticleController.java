package com.mhp.coding.challenges.mapping.controllers;

import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/all")
    public List<ArticleDto> list() {
        return this.articleService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> details(@PathVariable Long id) {

        ArticleDto articleDto;

        try {
            articleDto = this.articleService.articleForId(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(articleDto);
    }

    @PostMapping()
    public ArticleDto create(@RequestBody ArticleDto articleDto) {
        return this.articleService.create(articleDto);
    }
}
