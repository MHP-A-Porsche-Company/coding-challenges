package com.mhp.coding.challenges.dependency.notifications;

import java.util.Observable;
import java.util.Observer;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;
import com.mhp.coding.challenges.dependency.inquiry.InquiryService;

@Component
public class EmailHandler implements Observer {

    private static final Logger LOG = LoggerFactory.getLogger(EmailHandler.class);

	@Autowired
	InquiryService inquiryService;

	@PostConstruct
	public void init() {
		inquiryService.addObserver(this);
		LOG.info("EmailHandler is observing InquiryService");
	}

	public void sendEmail(Inquiry inquiry) {
		LOG.info("Sending email for: {}", inquiry);
    }

	@Override
	public void update(Observable o, Object inquiry) {
		this.sendEmail((Inquiry) inquiry);
	}

}
