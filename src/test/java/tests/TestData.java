package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    private static final Faker faker = new Faker((new Locale("en-GB")));

    public static String
        firstName = faker.name().firstName(),
        lastName = faker.name().lastName(),
        email = faker.internet().emailAddress(),
        notCorrectEmail = "123qwe",
        gender = faker.options().option("Male" , "Female" , "Other"),
        number = faker.number().digits(10),
        monthBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"),
        hobbies = faker.options().option("Sports" , "Reading" , "Music"),
        currentAddress = faker.address().fullAddress(),
        state = faker.options().option("NCR" , "Uttar Pradesh" , "Haryana" , "Rajasthan"),
        city = selectCity(state);


    public static String yearBirth = String.valueOf(faker.number().numberBetween(1950,2025));
    public static String dayBirth = String.format("%02d", faker.number().numberBetween(1,28));


    public static String selectCity (String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi" , "Gurgaon" , "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra" , "Lucknow" , "Merrut");
            case "Haryana" -> faker.options().option("Karnal" , "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur" , "Jaiselmer");
            default -> "";
        };
    }

    public static String dayOfBirthday = dayBirth + " " + monthBirth + "," + yearBirth,
    stateAndCity = state + " " + city,
    fullName = firstName + " " + lastName;



}
