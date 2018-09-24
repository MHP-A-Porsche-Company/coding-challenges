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
public class EmailHandler implements ApplicationListener<InquiryEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(EmailHandler.class);

	@Autowired
	InquiryService inquiryService;

	public void sendEmail(Inquiry inquiry) {
		LOG.info("Sending email for: {}", inquiry);
    }

	@Override
	public void onApplicationEvent(InquiryEvent inquiryEvent) {
		sendEmail(inquiryEvent.getInquiry());
	}
}
