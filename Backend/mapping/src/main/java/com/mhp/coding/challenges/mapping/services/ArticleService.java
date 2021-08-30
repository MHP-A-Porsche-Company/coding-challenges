package com.mhp.coding.challenges.mapping.services;

import com.mhp.coding.challenges.mapping.mappers.ArticleMapper;
import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final ArticleRepository repository;

    private final ArticleMapper mapper;

    @Autowired
    public ArticleService(ArticleRepository repository, ArticleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ArticleDto> list() {
        final List<Article> articles = repository.all();
        //TODO
        return articles.stream().map(mapper::map).collect(Collectors.toList());
    }

    public ArticleDto articleForId(Long id) {
        final Optional<Article> optionalArticle = repository.findBy(id);
        //TODO
        Article article = optionalArticle.orElseThrow(() -> new NoSuchElementException());

        return mapper.map(article);
    }

    public ArticleDto create(ArticleDto articleDto) {
        final Article create = mapper.map(articleDto);
        repository.create(create);
        return mapper.map(create);
    }
}
