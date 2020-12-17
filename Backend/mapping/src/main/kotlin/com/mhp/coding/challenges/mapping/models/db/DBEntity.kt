package com.mhp.coding.challenges.mapping.models.db

import java.util.*

open class DBEntity {
    var id: Long? = null
    var lastModified: Date? = null
    var lastModifiedBy: String? = null
}
