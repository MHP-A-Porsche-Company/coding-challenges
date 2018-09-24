package com.mhp.coding.challenges.dependency.inquiry;

import org.springframework.context.ApplicationEvent;

public class InquiryEvent extends ApplicationEvent {

	private Inquiry inquiry;

	public InquiryEvent(Object source, Inquiry inquiry) {
		super(source);
		this.inquiry = inquiry;
	}

	public Inquiry getInquiry() {
		return inquiry;
	}
}
