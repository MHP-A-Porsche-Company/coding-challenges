package com.mhp.coding.challenges.dependency.inquiry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class InquiryService {

	private static final Logger LOG = LoggerFactory.getLogger(InquiryService.class);

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

    public void create(final Inquiry inquiry) {
		InquiryEvent inquiryEvent = new InquiryEvent(this, inquiry);
		applicationEventPublisher.publishEvent(inquiryEvent);

        LOG.info("User sent inquiry: {}", inquiry);
    }
}
