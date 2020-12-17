package com.mhp.coding.challenges.mapping.models.dto.blocks

import com.mhp.coding.challenges.mapping.models.dto.ImageDto

data class GalleryBlockDto(
    var images: List<ImageDto>,
    override val sortIndex: Int,
) : ArticleBlockDto
