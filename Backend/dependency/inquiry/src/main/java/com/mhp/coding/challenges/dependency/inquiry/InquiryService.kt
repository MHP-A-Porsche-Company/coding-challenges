package com.mhp.coding.challenges.dependency.inquiry

import mu.KotlinLogging
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class InquiryService {
    fun create(inquiry: Inquiry) {
        logger.info {
            "User sent inquiry: $inquiry"
        }
    }
}

data class Inquiry(
    var username: String,
    var recipient: String,
    var text: String,
)
