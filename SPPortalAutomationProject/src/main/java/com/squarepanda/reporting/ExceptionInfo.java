package com.squarepanda.reporting;

import java.util.List;

import org.openqa.selenium.WebElement;


/**
 * The custom exception class.
 * 
 * 
 */
public class ExceptionInfo extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3387516993124229948L;
	private WebElement element;
	List<WebElement> elements;
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

	public ExceptionInfo(Exception e, WebElement element) {
		this.exception = e;
		this.element = element;
	}

	public ExceptionInfo(Exception e, WebElement element, String customMessage) {
		this.exception = e;
		this.element = element;
		this.customMessage = customMessage;
	}
	public ExceptionInfo(Exception e,List<WebElement> elements, String customMessage) {
		this.exception = e;
		this.elements = elements;
		this.customMessage = customMessage;
	}

	public ExceptionInfo(Exception e, WebElement element, String assertionType, Object actualValue,
			Object expectedValue) {
		this.exception = e;
		this.element = element;
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

	public WebElement getUiElement() {
		return element;

	}

	public ExceptionInfo setUiElement(WebElement element) {
		this.element = element;
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
