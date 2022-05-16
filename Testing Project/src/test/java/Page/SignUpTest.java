package Page;

import Constants.Constants;
import SeleniumDriver.ISeleniumDriver;
import SeleniumDriver.SeleniumDriver;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SignUpTest extends TestCase
{

    private ISeleniumDriver driver;
    private  SignUp signUpPage;

    @BeforeEach
    public void beforeEach()
    {
        driver     = new SeleniumDriver(Constants.LOGIN_PAGE_URL);
        signUpPage = new SignUp(driver);
    }

    @AfterEach
    public void afterEach()
    {
        driver.getDriver().close();
    }



    // Below informations are correct. I create an account.
    @ParameterizedTest
    @CsvSource(
                {
                        "email@gmail.com, H6d41f97d86f2b2",
                        "email@gmail.com, H6d41f97d86f2b2",
                        "email@gmail.com, dsgsdgsdg34g3drgdsfg34yg34gergdfgdf",
                        "email@gmail.com, fsdıouhf#$½$ßfdgdfgdf",
                        "emial@outlook.com, fjsowe8787/=(/)"
                }
             )
    @Order(1)
    @DisplayName("Unsuccessful Sign Up Operation")
    public void unSuccessfulSignUp(String email, String password)
    {
        assertFalse(signUpPage.signUp(email,password));
    }




    // Below informations do not validated. email extensions random. These do not exists!
    @ParameterizedTest
    @CsvSource(
            {
                    "dfhdf6756rfghfg@outlook.com, sglkjwe8923834@]{fsd",
                    "dfdsfdsfdsgdsgdsgds@yahoo.com, 378y34278fjsdN(/()"
            }
    )
    @Order(2)
    @DisplayName("Successful Sign Up Operation")
    public void successfulSignUp(String email, String password)
    {
        assertTrue(signUpPage.signUp(email,password));
    }




}