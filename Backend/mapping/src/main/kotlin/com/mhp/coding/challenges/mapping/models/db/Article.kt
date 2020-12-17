package com.mhp.coding.challenges.mapping.models.db

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock

class Article : DBEntity() {
    var title: String? = null
    var description: String? = null
    var author: String? = null
    var blocks: Set<ArticleBlock>? = null
}
