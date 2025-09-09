package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	
	Faker faker = new Faker();

	public String creatARandomFirstName() {

		return faker.name().firstName();

	}

	public String creatARandomLastName() {

		return faker.name().lastName();

	}

	public String generateAddress() {

		return faker.address().fullAddress();

	}

	public String generateEmail() {

		return faker.internet().emailAddress();

	}
	
	public String generatePhoneNumber() {
	    return faker.number().digits(10); 
	}
	
	


}