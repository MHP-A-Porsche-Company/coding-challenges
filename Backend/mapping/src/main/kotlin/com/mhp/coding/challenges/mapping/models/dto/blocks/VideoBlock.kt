package com.mhp.coding.challenges.mapping.models.dto.blocks

import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlockType

data class VideoBlock(
    var url: String,
    var type: VideoBlockType,
    override val sortIndex: Int,
) : ArticleBlockDto
