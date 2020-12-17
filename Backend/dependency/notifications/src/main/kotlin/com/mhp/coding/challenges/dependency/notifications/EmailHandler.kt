package com.mhp.coding.challenges.dependency.notifications

import com.mhp.coding.challenges.dependency.inquiry.Inquiry
import com.mhp.coding.challenges.dependency.notifications.EmailHandler
import mu.KotlinLogging
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class EmailHandler {
    fun sendEmail(inquiry: Inquiry) {
        logger.info {
            "Sending email for: $inquiry"
        }
    }
}
