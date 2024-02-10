package eCom.Utils;

import java.text.SimpleDateFormat;

import com.github.javafaker.Faker;

public class FakerClassTestData {

	private static Faker faker = new Faker();

	public static String generatePhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}

	public static String generateEmailAddress() {
		return faker.internet().emailAddress();
	}

	public static String generateFullName() {

		return faker.name().fullName();
	}

	public static String generateAdress() {
		return faker.address().fullAddress();
	}

	public static String generateDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(faker.date().birthday());
	}

	public static void main(String[] args) {
		System.out.println("Fake Mobile Number: " + generatePhoneNumber());
		System.out.println("Fake Email Address: " + generateEmailAddress());
		System.out.println("Fake Full Name: " + generateFullName());
		System.out.println("Fake Adress: " + generateAdress());
		System.out.println("Fake Birthday or date: " + generateDate());
	}
}
