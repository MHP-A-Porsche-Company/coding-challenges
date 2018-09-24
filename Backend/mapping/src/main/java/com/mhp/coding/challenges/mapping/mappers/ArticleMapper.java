package com.mhp.coding.challenges.mapping.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;

@Component
public class ArticleMapper extends ModelMapper {

	public ArticleDto map(Article article) {
		ArticleDto articleDto = this.map(article, ArticleDto.class);

		ArticleBlockMapper articleBlockMapper = new ArticleBlockMapper();
		Set<ArticleBlockDto> articleBlockDtoList = articleBlockMapper.mapList(article.getBlocks());
		articleDto.setBlocks(articleBlockDtoList);

		return articleDto;
	}

	public List<ArticleDto> mapList(List<Article> articles) {
		List<ArticleDto> articleDtoList = new ArrayList<>();
		for (Article article : articles) {
			ArticleDto articleDto = this.map(article);
			articleDtoList.add(articleDto);
		}
		return articleDtoList;
	}

	public Article map(ArticleDto articleDto) {
		// Nicht Teil dieser Challenge.
		return new Article();
	}
}
