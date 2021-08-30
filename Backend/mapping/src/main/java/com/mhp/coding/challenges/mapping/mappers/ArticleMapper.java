package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

@Component
public class ArticleMapper {

    public ArticleDto map(Article article){
        //TODO
        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .description(article.getDescription())
                .author(article.getAuthor())
                .blocks(
                        article.getBlocks().stream().map(
                                        articleBlock -> ArticleBlockDto.builder()
                                                .sortIndex(articleBlock.getSortIndex()).build())
                                .sorted(Comparator.comparing(ArticleBlockDto::getSortIndex))
                                .collect(Collectors.toCollection(LinkedHashSet::new))
                )
                .build();
    }

    public Article map(ArticleDto articleDto) {
        // Nicht Teil dieser Challenge.
        return new Article();
    }
}
