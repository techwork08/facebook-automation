package com.facebook.generic;

import java.text.SimpleDateFormat;

import java.util.Locale;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import com.github.javafaker.Faker;

public class FunctionUtilites {

	private static FunctionUtilites objFunctionUtilites;
	private static Pojo objpojo;

	public FunctionUtilites(Pojo pojo) {
		objpojo = pojo;
		// TODO Auto-generated constructor stub
	}

	public static FunctionUtilites getObj() {

		if (objFunctionUtilites == null) {
			objFunctionUtilites = new FunctionUtilites(objpojo);
		}
		return objFunctionUtilites;

	}

	public static Locale locale = new Locale("en-IN");
	static Faker faker = new Faker(locale);
	static Random random = new Random();

	public String getRandomFirstName() {
		String firstName = faker.name().firstName();
		return firstName;
	}

	public String getRandomLastName() {
		String lastName = faker.name().lastName();
		return lastName;
	}

	public String getRandomDateOfBirth(int minAge, int maxAge, String formatOfDate) {
		Faker objFaker = new Faker();
		SimpleDateFormat simpledateformat = new SimpleDateFormat(formatOfDate);
		String DOB = simpledateformat.format(objFaker.date().birthday(minAge, maxAge));
		return DOB;
	}

	public String generateRandomEmail(String firstName, String lastName) {
		String email = firstName + lastName + "@gmail.com";
		return email;

	}

	public String randomGender() {
		Random random = new Random();
		String[] selectGender = { "Male", "Female", "Custom" };
		int index = random.nextInt(selectGender.length);
		return selectGender[index];
	}

	public String getRandomCity() {

		String city = faker.address().city();

		return city;
	}

	public String getRandomNumber(int n)

	{

		String randomStr = "0123456789";

		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++)

		{

			int index = (int) (randomStr.length() * Math.random());

			sb.append(randomStr.charAt(index));

		}

		return sb.toString();

	}
	
	public String getNumber() {
		 Random random = new Random();
	        // generate random number from 0 to 3
	        int number = random.nextInt(80);
	        String age = String.valueOf(number);
	        
	        return age;
	}

}
