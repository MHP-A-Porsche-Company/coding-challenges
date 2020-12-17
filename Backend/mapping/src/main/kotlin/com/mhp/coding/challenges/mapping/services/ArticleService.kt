package com.mhp.coding.challenges.mapping.services

import com.mhp.coding.challenges.mapping.repositories.ArticleRepository
import com.mhp.coding.challenges.mapping.mappers.ArticleMapper
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val repository: ArticleRepository,
    private val mapper: ArticleMapper,
) {
    fun list(): List<ArticleDto> {
        val articles = repository.all()
        //TODO
        return emptyList()
    }

    fun articleForId(id: Long): ArticleDto {
        val article = repository.findBy(id)
        //TODO
        return ArticleDto()
    }

    fun create(articleDto: ArticleDto): ArticleDto {
        val article = mapper.map(articleDto)
        repository.create(article)
        return mapper.map(article)
    }
}
