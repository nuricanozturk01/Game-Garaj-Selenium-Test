package Page;

import Constants.Constants;
import SeleniumDriver.ISeleniumDriver;
import SeleniumDriver.SeleniumDriver;
import junit.framework.TestCase;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;

public class CartTest extends TestCase
{

    private  Login loginPage;
    private  ISeleniumDriver driver;
    private  Cart cartPage;

    private final By carTextFieldGamingNotebook = By.name("cart[7c5f46f657376bb078195b4cb11f6b84][qty]");
    private final By carTextFieldDesktopComputer = By.id("quantity_627fbdca57b7b");


    @BeforeEach
    public void init()
    {
        driver = new SeleniumDriver(Constants.LOGIN_PAGE_URL);
        loginPage = new Login(driver);
        cartPage = new Cart(driver);
        loginPage.run();
    }

    @AfterEach
    public void afterAll()
    {
        driver.getDriver().close();
    }


    @ParameterizedTest
    @Order(1)
    @CsvSource(
            {
                    "-9","9999999999999999999999",
                    "-1"
            }
    )
    public void inValidExpectedIncreaseTest(String value)
    {
        cartPage.goCartIcon();
        assertFalse(cartPage.increaseCartNumber(carTextFieldGamingNotebook,value));
    }

    @ParameterizedTest
    @Order(2)
    @CsvSource(
            {
                    "2","7","10","150",
                    "9223372036854775807","1"
            }
    )
    public void validExpectedIncreaseTest(String value)
    {
        cartPage.goCartIcon();
        assertTrue(cartPage.increaseCartNumber(carTextFieldGamingNotebook,value));
    }


}