package com.mhp.coding.challenges.dependency

import com.mhp.coding.challenges.dependency.inquiry.Inquiry
import com.mhp.coding.challenges.dependency.inquiry.InquiryService
import com.mhp.coding.challenges.dependency.notifications.EmailHandler
import com.mhp.coding.challenges.dependency.notifications.PushNotificationHandler
import com.ninjasquad.springmockk.SpykBean
import io.mockk.verify
import io.mockk.verifyAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [Application::class])
class InquiryTest(
    @Autowired private val inquiryService: InquiryService,
) {

    @SpykBean
    lateinit var emailHandler: EmailHandler

    @SpykBean
    lateinit var pushNotificationHandler: PushNotificationHandler

    @Test
    fun testInquiryHandlers() {
        val inquiry = Inquiry(
            username = "TestUser",
            recipient = "service@example.com",
            text = "Can I haz cheezburger?",
        ).also { inquiryService.create(it) }

        verifyAll {
            emailHandler.sendEmail(inquiry)
            pushNotificationHandler.sendNotification(inquiry)
        }
    }
}
