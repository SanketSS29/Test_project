package com.ProjectName.Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomValues
{
	public static String randomString()
	{
		String getRandomStr = RandomStringUtils.randomAlphabetic(5);
		return getRandomStr;
	}

	public static String randomNumber()
	{
		String getRandomNum = RandomStringUtils.randomNumeric(10);
		return getRandomNum;
	}
	

}
