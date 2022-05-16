package Page;

import Constants.Constants;
import Person.Person;
import SeleniumDriver.ISeleniumDriver;
import SeleniumDriver.SeleniumDriver;
import junit.framework.TestCase;
import Person.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PaymentTest extends TestCase
{
    private ISeleniumDriver driver;
    private Login loginPage;
    private Payment paymentPage;

    private Person person = new Person("45024166110","John","Wick","3684154658");		// All informations wrong (!)
    private CreditCard creditCard = new CreditCard("JOHN WICK","5101526623274405","1028","374");
    private Address address = new Address("Ankara","06080","Hatay","Istanbul");


    @BeforeEach
    public void init()
    {
        driver = new SeleniumDriver(Constants.LOGIN_PAGE_URL);
        loginPage = new Login(driver);
        paymentPage = new Payment(driver);
        person.setAddress(address);
        person.setCreditCard(creditCard);
    }



    @AfterEach
    public void close()
    {
        driver.getDriver().close();
    }




    @Test
    public void notAcceptConditions()
    {
        loginPage.run();
        paymentPage.run(person,false);
        assertFalse(paymentPage.getStatus());
    }

    @ParameterizedTest
    @CsvSource({"4521455742asd"})
    public void invalidIdentityNumber(String id)
    {
        person.setId(id);
        loginPage.run();
        paymentPage.run(person,true);
        assertFalse(paymentPage.getStatus());
    }

    @ParameterizedTest
    @CsvSource({"234bbhb"})
    public void invalidPostalCode(String postalCode)
    {
        person.setId("45024166110");
        person.getAddress().setPostalCode(postalCode);
        loginPage.run();
        paymentPage.run(person,true);
        assertFalse(paymentPage.getStatus());

    }

    @ParameterizedTest
    @CsvSource({"1893642875604358"})
    public void invalidCreditCardNumber(String cc)
    {
        person.getAddress().setPostalCode("06080");
        person.getCreditCard().setCreditCardNumber(cc);
        loginPage.run();
        paymentPage.run(person,true);
        assertFalse(paymentPage.getStatus());
    }


}