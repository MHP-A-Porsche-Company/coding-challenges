package com.mhp.coding.challenges.mapping.models.db.blocks

class VideoBlock(
    var url: String,
    var type: VideoBlockType,
    override val sortIndex: Int = 0,
) : ArticleBlock(sortIndex)

enum class VideoBlockType {
    YOUTUBE,
    VIMEO,
    TWITCH,
}
