package com.mhp.coding.challenges.mapping.models.dto

import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto

class ArticleDto(
    var id: Long? = null,
    var title: String? = null,
    var description: String? = null,
    var author: String? = null,
    var blocks: Collection<ArticleBlockDto>? = null,
)
