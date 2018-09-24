package com.mhp.coding.challenges.mapping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhp.coding.challenges.mapping.mappers.ArticleMapper;
import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.repositories.ArticleRepository;

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
		List<ArticleDto> articleDtoList = mapper.mapList(articles);
		return articleDtoList;
	}

	public ArticleDto articleForId(Long id) {
		final Article article = repository.findBy(id);
		ArticleDto articleDto = mapper.map(article);
		return articleDto;
	}

	public ArticleDto create(ArticleDto articleDto) {
		final Article create = mapper.map(articleDto);
		repository.create(create);
		return mapper.map(create);
	}
}
