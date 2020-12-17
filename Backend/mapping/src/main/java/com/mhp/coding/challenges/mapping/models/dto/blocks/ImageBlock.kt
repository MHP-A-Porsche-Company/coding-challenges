package com.mhp.coding.challenges.mapping.models.dto.blocks

import com.mhp.coding.challenges.mapping.models.dto.ImageDto

data class ImageBlock(
    var image: ImageDto,
    override val sortIndex: Int,
) : ArticleBlockDto
