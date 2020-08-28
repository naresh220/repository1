package com.squarepanda.seleniumUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.squarepanda.constants.WebDriverGlobalVariables;
import com.squarepanda.reporting.ExceptionInfo;

public class GenericMethods {
	
	public WebDriver getDriver() {
		Reporter.log("Getting the web driver.");
		return SeleniumDriver.getDriver();
	}
	 
	/**
	 * The method performs to wait driver.
	 * @return 
	 */
	public  void waitForElement(long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	public String getPageTitle() {
		return SeleniumDriver.getDriver().getTitle();
	}
	
	/**
	 * The method get's the source code of the current screen.
	 * 
	 * @return {@link String} the page source of the current page.
	 */
	public String getPageSource() {

		return getDriver().getPageSource();
	}
	
	/**
	 * The method performs a click on the web element.
	 * 
	 * @param web element to click.
	 */
	public void clickElement(WebElement element) {
		Reporter.log("Clicking on element with locator: " + element);
	
			try {
			
				element.click();
			
			} catch (Exception e) {
				throwErrorOnDefaultTimeout(e, element);
			}
		
	}
	
	
	/**
	 * The method sends in the input to the specified mobile element (like
	 * text-box..)
	 * 
	 * @param text value to input
	 * 
	 * @param loc  loc of the mobile element clear the value from.
	 */
	public void sendKeys(String text, WebElement element) {
		Reporter.log("Sending keys with text: " + text + " on an element with locator: " + element);
		setCurrentMillseconds();
		while (true) {
			try {
				element.clear();
				element.sendKeys(text);
				break;
			} catch (Exception e) {
				throwErrorOnDefaultTimeout(e, element);
			}
		}
	}
	/**
	 * The method clear the input from the specified mobile element (like
	 * text-box..)
	 * 
	 * @param loc loc of the mobile element to input value to.
	 */
	public void clearElement(WebElement element) {
		Reporter.log("Clearing the element with locator: " + element);
		setCurrentMillseconds();
		while (true) {
			try {
				element.clear();
				break;
			} catch (Exception e) {
				throwErrorOnDefaultTimeout(e, element);
			}
		}
	}
	/**
	 * The method gets the text value from the specified mobile element
	 * 
	 * @param loc loc of the mobile element to fetch text value.
	 */
	public String getText(WebElement element) {
		Reporter.log("Getting the text from the element with locator: " + element);
		setCurrentMillseconds();
		String value = "";
		while (true) {
			try {
				value = element.getText();
				return value;
			} catch (Exception e) {
				throwErrorOnDefaultTimeout(e, element);
			}
		}
	}

	/**
	 * The method checks if the element is present. Checks the tag name of the
	 * element.
	 * 
	 * @param loc loc of the element to check presence.
	 * 
	 * @return true if element is present else false.
	 */
	public boolean isElementPresent(WebElement element) {
		Reporter.log("Checking if element with locator: " + element + " is present.");
		setCurrentMillseconds();
		while (true) {
			try {
				element.getTagName();
				return true;
			} catch (Exception e) {
				if (isDefaultMinimumTimeoutOver()) {
					return false;
				}
			}
		}
	}
	
	/**
	 * The method checks if the element is present. Checks the tag name of the
	 * element.
	 * 
	 * @param loc     locator of the element to check presence.
	 * 
	 * @param timeOut the maximum time until which the element should be identified.
	 * 
	 * @return true if element is present else false.
	 */
	public boolean isElementPresent(WebElement element, int timeOut) {
		Reporter.log("Checking if element with locator: " + element + " is present with time period: " + timeOut);
		setCurrentMillseconds();
		for (int i = 0; i < timeOut; i++) {
			try {
				element.getTagName();
				return true;
			} catch (Exception e) {
				if (isGivenTimeoutOver(timeOut)) {
					return false;

				}
			}
		}
		return false;
	}
	
	/**
	 * The method asserts the element is not present.
	 * 
	 * @param loc locator of the element to assert the presence.
	 * 
	 */
	public void assertElementNotPresent(WebElement element,String elementName) {
		Reporter.log("Verifying element is not present.");
		assertValuesEqual(isElementPresent(element), false,
				elementName + "{ Description: " + element +  "} is present. However it should not be present.");
	}

	/**
	 * The method asserts the element is present.
	 * 
	 * @param loc locator of the element to assert the presence.
	 * 
	 */
	public void assertElementPresent(WebElement element,String elementName) {
		Reporter.log("Verifying element is present.");
		assertValuesEqual(isElementPresent(element), true,
				elementName + "{ Description: " + element +  "} is not present. However it should be present.");
	}
	
	/**
	 * The method checks if the element is visible.
	 * 
	 * @param loc     locator of the element to check visibility.
	 * 
	 * @param timeOut the maximum time until which the element should be identified.
	 * 
	 * @return true if element is visible else false.
	 */
	public boolean isElementVisible(WebElement element, int timeOutInSeconds) {
		Reporter.log("Checking if element with locator: " + element + " is visible with time period: " + timeOutInSeconds);
		setCurrentMillseconds();
		for (int i = 0; i < 100; i++) {
			try {
				return element.isDisplayed();
			} catch (Exception e) {
				if (isGivenTimeoutOver(timeOutInSeconds)) {
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * The method checks if the element is visible.
	 * 
	 * @param loc loc of the element to check visibility.
	 * 
	 * @return true if element is visible else false.
	 */
	public boolean isElementVisible(WebElement element) {
		Reporter.log("Checking if element with locator: " + element + " is visible.");
		setCurrentMillseconds();
		while (true) {
			try {
				return element.isDisplayed();
			} catch (Exception e) {
				if (isDefaultMinimumTimeoutOver()) {
					return false;
				}
			}
		}
	}
	
	/**
	 * The method verifies if the element is visible.
	 * 
	 * @param loc loc of the element to check visibility.
	 * 
	 * @throws Exception custom exception stating Element is not visible.
	 */
	public void verifyElementVisible(WebElement element) {
		Reporter.log("Verifying element with locator: " + element + " is visible.");
		setCurrentMillseconds();
		while (true) {
			try {
				element.isDisplayed();
				break;
			} catch (Exception e) {
				if (isDefaultMinimumTimeoutOver()) {
					throwErrorOnDefaultTimeout(e, element, "Element is not visible");
				}
			}
		}
	}

	/**
	 * The method verifies element is not visible.
	 * 
	 * @param loc locator of the element to check visibility.
	 * 
	 * @throws Exception custom exception stating Element is visible.
	 */
	public void verifyElementNotVisible(WebElement element) {
		Reporter.log("Verifying element with locator: " + element + " is not visible.");
		setCurrentMillseconds();
		while (true) {
			try {
				if (element.isDisplayed())
					throwErrorOnDefaultTimeout(new Exception("Assertion Fail"), "Element should not be visible");
				else
					break;
			} catch (Exception e) {
				if (isDefaultMinimumTimeoutOver()) {
					throwErrorOnDefaultTimeout(e, element, "Element should not be visible");
				}
			}
		}
	}
	/**
	 * The method causes the thread to stop for supplied duration.
	 * 
	 * @param seconds how long the execution should stop.
	 */
	public void waitFor(long seconds) {
		Reporter.log("Waiting for " + seconds + "seconds.");
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * The method asserts the actual and expected values. This is done using
	 * {@link TestNG} assert
	 * 
	 * @param actualValue   actual value. Type is {@link Object}
	 * 
	 * @param expectedValue expected value. Type is {@link Object}
	 * 
	 * @throws AssertFailure custom assertion failure message
	 */
	public void assertValuesEqual(Object actualValue, Object expectedValue, String... optionalMessage) {
		if (optionalMessage.length != 0)
			Reporter.log("Asserting " + optionalMessage[0].trim());
		else
			Reporter.log("Asserting the actual-value" + actualValue + " is equals the expected-value" + expectedValue);
		setCurrentMillseconds();
		while (true) {
			try {
				if (actualValue instanceof String || actualValue instanceof ArrayList<?>
						|| actualValue instanceof Arrays) {
					if (actualValue.equals(expectedValue))
						break;
					else {
						if (optionalMessage.length != 0)
							throwErrorOnDefaultTimeout(new Exception("Assertion Fail"), optionalMessage[0].trim());
						else
							throwErrorOnDefaultTimeout(new Exception("Assertion Fail"),
									"Actual and Expected values do not match.\nActual value: " + actualValue
											+ "\nExpected value: " + expectedValue);
					}
				} else {
					if (actualValue == expectedValue)
						break;
					else {
						if (optionalMessage.length != 0)
							throwErrorOnDefaultTimeout(new Exception("Assertion Fail"), optionalMessage[0].trim());
						else
							throwErrorOnDefaultTimeout(new Exception("Assertion Fail"),
									"Actual and Expected values do not match.\nActual value: " + actualValue
											+ "\nExpected value: " + expectedValue);
					}
				}
			} catch (Exception e) {
				if (isDefaultMinimumTimeoutOver())
					if (optionalMessage.length != 0)
						throwErrorOnDefaultTimeout(e, optionalMessage[0].trim());
					else
						throwErrorOnDefaultTimeout(e, "Actual and Expected values do not match.\nActual value: "
								+ actualValue + "\nExpected value: " + expectedValue);
			}
		}
	}
	/**
	 * The method scans through the list of elements. It checks if the text of the
	 * element matches the expected text and clicks that element.
	 * 
	 * @param loc         the locator the element.
	 * 
	 * @param textToMatch the text to match with the element's text.
	 * 
	 * @throws throwErrorOnDefaultTimeoutException custom exception stating None of
	 *                                             the element matched the search
	 *                                             text.
	 */
	public void scanThroughTheListOfElementsAndClick(List<WebElement> elements, String textToMatch) {
		Reporter.log("Scanning through the list of elements with locator: " + elements + " with text: " + textToMatch
				+ " to click the element.");
		setCurrentMillseconds();
		boolean found = false;
		while (true) {
			try {
				List<WebElement> values = elements;
				for (WebElement value : values) {
					if (value.getText().equals(textToMatch)) {
						found = true;
						value.click();
						break;
					}
				}
				if (found == false)
					throwErrorOnDefaultTimeout(new Exception("Assertion Fail"), elements,
							"None of the element matched the search text: " + textToMatch);
				else
					break;
			} catch (Exception e) {
				throwErrorOnDefaultTimeout(new Exception("Assertion Fail"), elements,
						"None of the element matched the search text: " + textToMatch);
			}
		}
	}
	/**
	 * The method asserts values in the list of element contains the expected value
	 * 
	 * @param list          the list of elements.
	 * 
	 * @param expectedValue expected value.
	 * 
	 * @throws throwErrorOnDefaultTimeoutException custom exception stating List
	 *                                             does not contains the expected
	 *                                             value.
	 */
	public void assertListContainsValue(List<Object> list, Object expectedValue) {
		Reporter.log("Asserting the list: " + list + " contains the value: " + expectedValue);
		boolean found = false;
		setCurrentMillseconds();
		while (true) {
			try {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) instanceof String) {
						if (list.get(i).equals(expectedValue)) {
							found = true;
							break;
						}

					} else {
						if (list.get(i) == expectedValue) {
							found = true;
							break;
						}
					}
				}
				if (found == false)
					throwErrorOnDefaultTimeout(new Exception("Assertion Fail"),
							"List does not contains the expected value.\nElements in the list: " + list.toString()
									+ "\nExpected value: " + expectedValue);
				else
					break;

			} catch (Exception e) {
				throwErrorOnDefaultTimeout(new Exception("Assertion Fail"),
						"List does not contains the expected value.\nElements in the list: " + list.toString()
								+ "\nExpected value: " + expectedValue);
			}
		}
	}

	/**
	 * The method asserts values in the list of element does not contain the
	 * expected value
	 * 
	 * @param list          the list of elements.
	 * 
	 * @param expectedValue expected value.
	 * 
	 * @throws throwErrorOnDefaultTimeoutException custom exception stating List
	 *                                             contains the expected value.
	 */
	public void assertListDoesntContainValue(List<Object> list, Object expectedValue) {
		Reporter.log("Asserting the list: " + list + " does not contain the value: " + expectedValue);
		boolean found = false;
		setCurrentMillseconds();
		while (true) {
			try {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) instanceof String) {
						if (list.get(i).equals(expectedValue)) {
							found = true;
							break;
						}

					} else {
						if (list.get(i) == expectedValue) {
							found = true;
							break;
						}
					}
				}
				if (found == true)
					throwErrorOnDefaultTimeout(new Exception("Assertion Fail"),
							"List contains the expected value.\nElements in the list: " + list.toString()
									+ "\nExpected value: " + expectedValue);
				else
					break;

			} catch (Exception e) {
				throwErrorOnDefaultTimeout(new Exception("Assertion Fail"),
						"List contains the expected value.\nElements in the list: " + list.toString()
								+ "\nExpected value: " + expectedValue);
			}
		}
	}
	/**
	 * The method asserts the element is not present.
	 * 
	 * @param loc locator of the element to assert the presence.
	 * 
	 */
	public void assertElementNotPresent(WebElement element) {
		Reporter.log("Verifying element is not present.");
		assertValuesEqual(isElementPresent(element), false,
				"Element with locator"+element+"} is present. However it should not be present.");
	}

	
	
	/*
	 * Code for custom exception
	 */
	private static String pageName = null;
	private String browserName;
	private String runType;
	private String browserVersion;

	/**
	 * Set page name. <br/>
	 * Should be only used in page classes.
	 * 
	 * @param pageName
	 */
	public static void setPageName(String pageName) {
		GenericMethods.pageName = pageName;
	}

	/**
	 * Return page name.
	 * 
	 * @return
	 */
	public static String getPageName() {
		return pageName;
	}

	/**
	 * Return selected browser name.
	 * 
	 * @return
	 */
	protected String getBrowserName() {
		return browserName;
	}

	/**
	 * Return run type. local or hub name.
	 * 
	 * @return
	 */
	protected String getRunType() {
		return runType;
	}

	/**
	 * Return browser version.
	 * 
	 * @return
	 */
	protected String getBrowserVersion() {
		return browserVersion;
	}
	
	public final static int defaultWaitForTimeout = WebDriverGlobalVariables.defaultWaitForTimeout;
	public final int dafaultMinimumWaitTimeout = WebDriverGlobalVariables.defaultMinElementTimeout;
	private long currentMills;

	private void setCurrentMillseconds() {
		currentMills = System.currentTimeMillis();
	}

	@SuppressWarnings("unused")
	private void throwErrorOnDefaultTimeout(Exception e) {
		if (System.currentTimeMillis() - currentMills > (defaultWaitForTimeout * 1000)) {
			throw new ExceptionInfo(e);
		}
	}

	private void throwErrorOnDefaultTimeout(Exception e, WebElement element) {
		if (System.currentTimeMillis() - currentMills > (defaultWaitForTimeout * 1000)) {
			throw new ExceptionInfo(e, element);
		}
	}

	private void throwErrorOnDefaultTimeout(Exception e, String customMessage) {
		if (System.currentTimeMillis() - currentMills > (defaultWaitForTimeout * 1000)) {
			throw new ExceptionInfo(e, customMessage);
		}
	}

	private void throwErrorOnDefaultTimeout(Exception e, WebElement element, String customMessage) {
		if (System.currentTimeMillis() - currentMills > (defaultWaitForTimeout * 1000)) {
			throw new ExceptionInfo(e, element, customMessage);
		}
	}
	private void throwErrorOnDefaultTimeout(Exception e, List<WebElement> element, String customMessage) {
		if (System.currentTimeMillis() - currentMills > (defaultWaitForTimeout * 1000)) {
			throw new ExceptionInfo(e, element, customMessage);
		}
	}

	@SuppressWarnings("unused")
	private void throwErrorOnDefaultTimeout(Exception e, WebElement element, String assertionType, Object actual,
			Object expected) {
		if (System.currentTimeMillis() - currentMills > (defaultWaitForTimeout * 1000)) {
			throw new ExceptionInfo(e, element, assertionType, actual, expected);
		}
	}

	@SuppressWarnings("unused")
	private void throwErrorOnMinimumTimeout(Exception e, WebElement element) {
		if (System.currentTimeMillis() - currentMills > (dafaultMinimumWaitTimeout * 1000)) {
			throw new ExceptionInfo(e, element);
		}
	}

	@SuppressWarnings("unused")
	private void throwErrorOnMinimumTimeout(Exception e) {
		if (System.currentTimeMillis() - currentMills > (dafaultMinimumWaitTimeout * 1000)) {
			throw new ExceptionInfo(e);
		}
	}

	private boolean isDefaultMinimumTimeoutOver() {
		if (System.currentTimeMillis() - currentMills > (dafaultMinimumWaitTimeout * 1000)) {
			return true;
		} else {
			return false;
		}
	}

	
	private boolean isGivenTimeoutOver(int timeout) {
		if (System.currentTimeMillis() - currentMills > (timeout * 1000)) {
			return true;
		} else {
			return false;
		}
	}


}
