package com.mhp.coding.challenges.mapping.models.db

import java.util.*

class Image(
    var url: String,
    var imageSize: ImageSize,
    override var id: Long,
    override var lastModified: Date,
    override var lastModifiedBy: String? = null
) : DBEntity

enum class ImageSize {
    SMALL,
    MEDIUM,
    LARGE,
}
