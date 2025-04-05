package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

import static org.openqa.selenium.internal.Require.state;


public class TestData {
    private final Faker faker = new Faker((new Locale("en-GB")));

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String notCorrectEmail = "123qwe";

    public String getGender() {
        return faker.options().option("Male" , "Female" , "Other");
    }

    public String getNumber() {
        return faker.number().digits(10);
    }

    public String getMonthBirth() {
        return faker.options().option("January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December");
    }

    public String getHobbies() {
        return faker.options().option("Sports" , "Reading" , "Music");
    }

    public String getCurrentAddress() {
        return faker.address().fullAddress();
    }

    public String getState() {
        return faker.options().option("NCR" , "Uttar Pradesh" , "Haryana" , "Rajasthan");
    }

    public String getYearBirth() {
        return String.valueOf(faker.number().numberBetween(1950,2025));
    }

    public String getDayBirth() {
        return String.format("%02d", faker.number().numberBetween(1,28));
    }

    public String getSelectCity (String getState) {
        return switch(getState) {
            case "NCR" -> faker.options().option("Delhi" , "Gurgaon" , "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra" , "Lucknow" , "Merrut");
            case "Haryana" -> faker.options().option("Karnal" , "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur" , "Jaiselmer");
            default -> "";
        };
    }

}
