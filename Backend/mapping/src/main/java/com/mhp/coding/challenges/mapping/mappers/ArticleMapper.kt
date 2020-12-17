package com.mhp.coding.challenges.mapping.mappers

import com.mhp.coding.challenges.mapping.models.db.Article
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import org.springframework.stereotype.Component

@Component
class ArticleMapper {
    fun map(article: Article?): ArticleDto {
        //TODO
        return ArticleDto()
    }

    // Nicht Teil dieser Challenge.
    fun map(articleDto: ArticleDto?): Article = Article()
}