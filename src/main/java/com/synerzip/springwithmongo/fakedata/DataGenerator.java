package com.synerzip.springwithmongo.fakedata;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.bloco.faker.Faker;

import com.synerzip.springwithmongo.model.User;

public class DataGenerator {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		for (int i = 1; i < 5; i++) {
			User user  = new User();
			Faker faker = new Faker();
			user.setUserId(i);
			user.setFirstName(faker.name.firstName());
			user.setLastName(faker.name.lastName());
			user.setMobile(faker.phoneNumber.phoneNumber());
			user.setEmail(faker.internet.email());
			user.setPrice((int )(Math.random() * 200 + 1));
			System.out.println(user);
		}
	
	}
}