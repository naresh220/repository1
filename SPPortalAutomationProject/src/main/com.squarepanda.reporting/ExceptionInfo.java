package com.squarepanda.reporting;

import com.squarepanda.appiumUtility.Locator;

/**
 * The custom exception class.
 * 
 * @author Zaid Momin
 * 
 */
public class ExceptionInfo extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8279928608749013759L;
	private Locator uiElement;
	private String customMessage;
	private String assertionType;
	private Object actualValue;
	private Object expectedValue;
	private Exception exception;

	public ExceptionInfo(Exception e) {
		this.exception = e;
	}

	public ExceptionInfo(Exception e, String customMessage) {
		this.exception = e;
		this.customMessage = customMessage;
	}

	public ExceptionInfo(Exception e, Locator uiElement) {
		this.exception = e;
		this.uiElement = uiElement;
	}

	public ExceptionInfo(Exception e, Locator uiElement, String customMessage) {
		this.exception = e;
		this.uiElement = uiElement;
		this.customMessage = customMessage;
	}

	public ExceptionInfo(Exception e, Locator uiElement, String assertionType, Object actualValue,
			Object expectedValue) {
		this.exception = e;
		this.uiElement = uiElement;
		this.assertionType = assertionType;
		this.actualValue = actualValue;
		this.expectedValue = expectedValue;
	}

	public String getCustomMessage() {
		return customMessage;

	}

	public ExceptionInfo setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
		return this;
	}

	public Locator getUiElement() {
		return uiElement;

	}

	public ExceptionInfo setUiElement(Locator uiElement) {
		this.uiElement = uiElement;
		return this;
	}

	public String getAssertionType() {
		return assertionType;
	}

	public Exception getException() {
		return exception;
	}

	public ExceptionInfo setAssertionType(String assertionType) {
		this.assertionType = assertionType;
		return this;
	}

	public Object getActualValue() {
		return actualValue;
	}

	public ExceptionInfo setActualValue(String actualValue) {
		this.actualValue = actualValue;
		return this;
	}

	public Object getExpectedValue() {
		return expectedValue;
	}

	public ExceptionInfo setExpectedValue(String expectedValue) {
		this.expectedValue = expectedValue;
		return this;
	}
}
