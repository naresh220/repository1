package com.squarepanda.reporting;

/**
 * This class will provide custom exception for API related test cases.
 * 
 */
public class ExceptionInfoApi extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7087492579084483889L;

	private String responseMessage;
	private String uri;
	private String payLoad;
	private Integer responseStatusCode;
	private String responseBody;
	private String customMessage;
	private Object actualValue;
	private Object expectedValue;
	private Exception exception;

	public ExceptionInfoApi() {

	}

	public ExceptionInfoApi(Exception e) {
		this.exception = e;
	}

	public ExceptionInfoApi(Exception e, String customMessage) {
		this.exception = e;
		this.customMessage = customMessage;
	}

	public ExceptionInfoApi(Exception e, String uri, Integer responseStatusCode, String payLoad,
			String responseMessage) {
		this.exception = e;
		this.uri = uri;
		this.responseStatusCode = responseStatusCode;
		this.payLoad = payLoad;
		this.responseMessage = responseMessage;
	}

	public ExceptionInfoApi(Exception e, String uri, Integer responseStatusCode, String responseMessage) {
		this.exception = e;
		this.uri = uri;
		this.responseStatusCode = responseStatusCode;
		this.responseMessage = responseMessage;
	}

	public ExceptionInfoApi(Exception e, String customMessage, Object actualValue, Object expectedValue) {
		this.exception = e;
		this.customMessage = customMessage;
		this.actualValue = actualValue;
		this.expectedValue = expectedValue;
	}

	public ExceptionInfoApi(String uri, Integer responseStatusCode, String payLoad, String responseMessage,
			Object actualValue, Object expectedValue, String customMessage) {
		this.uri = uri;
		this.responseStatusCode = responseStatusCode;
		this.payLoad = payLoad;
		this.responseMessage = responseMessage;
		this.customMessage = customMessage;
		this.actualValue = actualValue;
		this.expectedValue = expectedValue;
	}

	public ExceptionInfoApi(Exception e, String uri, Integer responseStatusCode, String payLoad, String responseMessage,
			Object actualValue, Object expectedValue, String customMessage) {
		this.exception = e;
		this.uri = uri;
		this.responseStatusCode = responseStatusCode;
		this.payLoad = payLoad;
		this.responseMessage = responseMessage;
		this.customMessage = customMessage;
		this.actualValue = actualValue;
		this.expectedValue = expectedValue;
	}

	public ExceptionInfoApi(String uri, Integer responseStatusCode, String payLoad, String responseMessage,
			String reponseBody, Object actualValue, Object expectedValue, String customMessage) {
		this.uri = uri;
		this.responseStatusCode = responseStatusCode;
		this.payLoad = payLoad;
		this.responseMessage = responseMessage;
		this.customMessage = customMessage;
		this.actualValue = actualValue;
		this.expectedValue = expectedValue;
		this.setResponseBody(reponseBody);
	}

	public ExceptionInfoApi(Exception e, String uri, Integer responseStatusCode, String payLoad, String responseMessage,
			String reponseBody, Object actualValue, Object expectedValue, String customMessage) {
		this.exception = e;
		this.uri = uri;
		this.responseStatusCode = responseStatusCode;
		this.payLoad = payLoad;
		this.responseMessage = responseMessage;
		this.customMessage = customMessage;
		this.actualValue = actualValue;
		this.expectedValue = expectedValue;
		this.setResponseBody(reponseBody);
	}

	public String getCustomMessage() {
		return customMessage;

	}

	public ExceptionInfoApi setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
		return this;
	}

	public String getResponseMessage() {
		return responseMessage;

	}

	public ExceptionInfoApi setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
		return this;
	}

	public Exception getException() {
		return exception;
	}

	public Object getActualValue() {
		return actualValue;
	}

	public ExceptionInfoApi setActualValue(String actualValue) {
		this.actualValue = actualValue;
		return this;
	}

	public Object getExpectedValue() {
		return expectedValue;
	}

	public ExceptionInfoApi setExpectedValue(String expectedValue) {
		this.expectedValue = expectedValue;
		return this;
	}

	public Integer getResponseStatusCode() {
		return responseStatusCode;
	}

	public void setResponseStatusCode(Integer responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
	}

	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * @return the payLoad
	 */
	public String getPayLoad() {
		return payLoad;
	}

	/**
	 * @param payLoad the payLoad to set
	 */
	public void setPayLoad(String payLoad) {
		this.payLoad = payLoad;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
}
