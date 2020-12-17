package com.mhp.coding.challenges.mapping.controllers

import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import com.mhp.coding.challenges.mapping.services.ArticleService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/article")
class ArticleController(
    private val articleService: ArticleService
) {
    @GetMapping
    fun list(): List<ArticleDto> = articleService.list()

    @GetMapping("/{id}")
    fun details(@PathVariable id: Long): ArticleDto = articleService.articleForId(id)

    @PostMapping
    fun create(@RequestBody articleDto: ArticleDto): ArticleDto = articleService.create(articleDto)
}
