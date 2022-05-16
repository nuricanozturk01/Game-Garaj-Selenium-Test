package Page;

import SeleniumDriver.ISeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

public class SignUp
{
    private ISeleniumDriver driver;
    private final String EMAIL_FIELD_ID = "reg_email";
    private final String PASSWORD_FIELD_ID = "reg_password";
    private final String SIGN_UP_BUTTON = "#customer_login > div.u-column2.col-2 > form > p:nth-child(4) > button";

    private final String NON_MEMBERED_EMAIL = "email@gmail.com";
    private final String PASSWORD_REF_NON_MEMBERED = "H6d41f97d86f2b2";

    private final String NON_EXISTS_EMAIL = "fnsdşgnlkjsdanglkuskeasl@gmail.com";
    private final String PASSWORD_REF_NON_EXISTS = "thisP@ssw0rd|_|nsafe ";
    public SignUp(ISeleniumDriver driver)
    {
        this.driver = driver;
    }

    public boolean signUp(String email, String password)
    {
        try
        {
            driver.findElement(By.id(EMAIL_FIELD_ID)).sendKeys(Keys.BACK_SPACE);
            driver.sendKeys(By.id(EMAIL_FIELD_ID),email);
            driver.sendKeys(By.id(PASSWORD_FIELD_ID),password);
            driver.click(By.cssSelector(SIGN_UP_BUTTON));
            Thread.sleep(10000);

            if(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div[2]/div/div/div/div[1]/ul/li[3]/a")).getText() == null)
                throw new NoSuchElementException("NO");
        }
        catch (NoSuchElementException ex)
        {
            return false;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return true;
    }
    public void successfulSignUp()
    {
        driver.sendKeys(By.id(EMAIL_FIELD_ID),NON_MEMBERED_EMAIL);
        driver.sendKeys(By.id(PASSWORD_FIELD_ID),PASSWORD_REF_NON_MEMBERED);
        driver.click(By.cssSelector(SIGN_UP_BUTTON));
    }

}
