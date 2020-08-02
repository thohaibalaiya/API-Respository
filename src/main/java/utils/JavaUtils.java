package utils;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class JavaUtils {
	
	public String randomnumber() {
		Random random = new Random();
		int randomnumber = random.nextInt(100);
		String id =Integer.toString(randomnumber);
		return id;
		
	}
	
	public  String randomString() {
	String randomString = RandomStringUtils.randomAlphabetic(5);
	return randomString;
	}

	
	


}
