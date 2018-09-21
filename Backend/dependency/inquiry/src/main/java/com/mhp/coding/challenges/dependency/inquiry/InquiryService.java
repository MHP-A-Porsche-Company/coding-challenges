package com.mhp.coding.challenges.dependency.inquiry;

import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class InquiryService extends Observable {

    private static final Logger LOG = LoggerFactory.getLogger(InquiryService.class);

    public void create(final Inquiry inquiry) {
        LOG.info("User sent inquiry: {}", inquiry);
		setChanged();
		notifyObservers(inquiry);
    }

}
