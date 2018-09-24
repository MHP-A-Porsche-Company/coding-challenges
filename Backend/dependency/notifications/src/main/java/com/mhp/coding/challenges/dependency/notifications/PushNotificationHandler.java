package com.mhp.coding.challenges.dependency.notifications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;
import com.mhp.coding.challenges.dependency.inquiry.InquiryEvent;
import com.mhp.coding.challenges.dependency.inquiry.InquiryService;

@Component
public class PushNotificationHandler implements ApplicationListener<InquiryEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(PushNotificationHandler.class);

	@Autowired
	InquiryService inquiryService;

	public void sendNotification(final Inquiry inquiry) {
		LOG.info("Sending push notification for: {}", inquiry);
    }

	@Override
	public void onApplicationEvent(InquiryEvent inquiryEvent) {
		sendNotification(inquiryEvent.getInquiry());
	}
}
