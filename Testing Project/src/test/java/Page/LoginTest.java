package Page;

import Constants.Constants;
import SeleniumDriver.ISeleniumDriver;
import SeleniumDriver.SeleniumDriver;
import junit.framework.TestCase;
import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest extends TestCase
{
    private  ISeleniumDriver driver;
    private  Login loginPage;


    @BeforeEach
    public void beforeAll()
    {
        driver = new SeleniumDriver(Constants.LOGIN_PAGE_URL);
        loginPage = new Login(driver);
    }

    @AfterEach
    public void afterEach()
    {
        driver.getDriver().close();
    }
    @ParameterizedTest
    @CsvSource({"email@gmail.com, H6d41f97d86f2b2"})
    @Order(1)
    @DisplayName("Success Login")
    public void successfullLogin(String email, String password)
    {
        assertTrue(loginPage.login(email,password));

    }

    @ParameterizedTest
    @CsvSource({"dsf8g7AS7j@yahoo.com, H6d41f97d86f2b2",
                "your_email@gmail.com, 378y34278fjsdN(/()"})
    @Order(2)
    @DisplayName("Unsuccess Login")
    public void unsuccessfullLogin(String email, String password)
    {
        assertFalse(loginPage.login(email,password));

    }

}