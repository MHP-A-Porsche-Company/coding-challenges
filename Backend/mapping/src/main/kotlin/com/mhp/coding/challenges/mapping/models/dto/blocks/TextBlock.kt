package com.mhp.coding.challenges.mapping.models.dto.blocks

data class TextBlock(
    var text: String,
    override val sortIndex: Int,
) : ArticleBlockDto
