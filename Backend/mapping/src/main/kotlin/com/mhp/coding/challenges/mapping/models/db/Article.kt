package com.mhp.coding.challenges.mapping.models.db

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock
import java.util.*

class Article(
    var title: String,
    var description: String? = null,
    var author: String? = null,
    var blocks: Set<ArticleBlock>,
    override var id: Long,
    override var lastModified: Date,
    override var lastModifiedBy: String? = null
) : DBEntity
