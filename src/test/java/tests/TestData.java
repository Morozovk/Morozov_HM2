package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.devtools.v132.css.model.Value;

import java.util.Locale;

public class TestData {
    private final Faker faker = new Faker((new Locale("en-GB")));

    public String firstName() {
        return faker.name().firstName();
    }

    public String lastName() {
        return faker.name().lastName();
    }

    public String email() {
        return faker.internet().emailAddress();
    }

    public String notCorrectEmail = "123qwe";

    public String gender() {
        return faker.options().option("Male" , "Female" , "Other");
    }

    public String number() {
        return faker.number().digits(10);
    }

    public String monthBirth() {
        return faker.options().option("January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December");
    }

    public String hobbies() {
        return faker.options().option("Sports" , "Reading" , "Music");
    }

    public String currentAddress() {
        return faker.address().fullAddress();
    }

    public String state() {
        return faker.options().option("NCR" , "Uttar Pradesh" , "Haryana" , "Rajasthan");
    }

    public String city = selectCity(state());

    public String yearBirth() {
        return String.valueOf(faker.number().numberBetween(1950,2025));
    }

    public String dayBirth() {
        return String.format("%02d", faker.number().numberBetween(1,28));
    }


    public String selectCity (String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi" , "Gurgaon" , "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra" , "Lucknow" , "Merrut");
            case "Haryana" -> faker.options().option("Karnal" , "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur" , "Jaiselmer");
            default -> "";
        };
    }

    public String dayOfBirthday = dayBirth() + " " + monthBirth() + "," + yearBirth(),
    stateAndCity = state() + " " + city,
    fullName = firstName() + " " + lastName();
}
