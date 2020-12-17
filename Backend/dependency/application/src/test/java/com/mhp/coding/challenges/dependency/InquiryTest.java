package com.mhp.coding.challenges.dependency;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;
import com.mhp.coding.challenges.dependency.inquiry.InquiryService;
import com.mhp.coding.challenges.dependency.notifications.EmailHandler;
import com.mhp.coding.challenges.dependency.notifications.PushNotificationHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Application.class)
public class InquiryTest {

    @SpyBean
    private EmailHandler emailHandler;

    @SpyBean
    private PushNotificationHandler pushNotificationHandler;

    @Autowired
    private InquiryService inquiryService;

    @Test
    public void testInquiryHandlers() {
        final Inquiry inquiry = new Inquiry();
        inquiry.setUsername("TestUser");
        inquiry.setRecipient("service@example.com");
        inquiry.setText("Can I haz cheezburger?");

        inquiryService.create(inquiry);

        verify(emailHandler).sendEmail(eq(inquiry));
        verify(pushNotificationHandler).sendNotification(eq(inquiry));
    }
}
