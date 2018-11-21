package com.mhp.coding.challenges.dependency.inquiry;

import com.mhp.coding.challenges.dependency.notifications.EmailHandler;
import com.mhp.coding.challenges.dependency.notifications.PushNotificationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InquiryService {

    private static final Logger LOG = LoggerFactory.getLogger(InquiryService.class);

    private Inquiry inquiry;

    @Autowired
    private EmailHandler emailHandler;

    @Autowired
    private PushNotificationHandler pushNotificationHandler;

    public void create(final Inquiry inquiry) {
        this.inquiry = inquiry;
        LOG.info("User sent inquiry: {}", inquiry);
        emailHandler.sendEmail(inquiry);
        pushNotificationHandler.sendNotification(inquiry);
    }



}
