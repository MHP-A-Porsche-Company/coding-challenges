package com.mhp.coding.challenges.mapping.models.db.blocks

import com.mhp.coding.challenges.mapping.models.db.Image

class GalleryBlock : ArticleBlock() {
    var images: List<Image>? = null
}
