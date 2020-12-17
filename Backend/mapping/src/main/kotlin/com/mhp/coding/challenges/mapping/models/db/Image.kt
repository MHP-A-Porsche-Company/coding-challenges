package com.mhp.coding.challenges.mapping.models.db

class Image : DBEntity() {
    var url: String? = null
    var imageSize: ImageSize? = null
}
