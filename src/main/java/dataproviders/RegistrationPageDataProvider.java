package dataproviders;

import com.github.javafaker.Faker;
import model.AccountBuilder;
import org.testng.annotations.DataProvider;

public class RegistrationPageDataProvider {

    public Faker faker = new Faker();

    @DataProvider
    public Object[][] registerNewUser() {
        return new Object[][] {
                {
                    new AccountBuilder()
                            .withGender("1")
                            .withFirstCustomerName("Oleksandr")
                            .withLastCustomerName("Barylovskyi")
                            .withEmail(faker.internet().emailAddress())
                            .withPassword("QWErty123")
                            .withBirthdayDay("23")
                            .withBirthdayMonth("3")
                            .withBirthdayYear("1993")
                            .withFirstName("Oleksandr")
                            .withLastName("Barylovskyi")
                            .withCompany("Apple")
                            .withAddress1("Ocean Street 58")
                            .withAddress2("Ocean Street 85")
                            .withCity("Chicago")
                            .withState("13")
                            .withPostalCode("12345")
                            .withCountry("21")
                            .withPhoneMobile("123456789")
                            .withAliasAddress("Hello!")
                            .build()

                }
        };
    }
}
