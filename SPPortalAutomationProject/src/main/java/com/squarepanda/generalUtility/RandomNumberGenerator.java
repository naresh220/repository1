package com.squarepanda.generalUtility;

import org.apache.commons.lang.RandomStringUtils;

public class RandomNumberGenerator {

	public static String generateRandomAlphaNumericString(int length) {
		return RandomStringUtils.random(length, true, true);
	}

	public static String generateRandomNumber(int length) {
		return RandomStringUtils.random(length, false, true);
	}
	
}
