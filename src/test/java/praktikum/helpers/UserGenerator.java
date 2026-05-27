package praktikum.helpers;

import com.github.javafaker.Faker;

public class UserGenerator {

    private static final Faker faker = new Faker();

    public static User getRandomUser() {
        return new User(
                faker.name().firstName(),
                faker.internet().emailAddress(),
                faker.internet().password(6, 10)
        );
    }

}
