package Page;

import Constants.Constants;
import SeleniumDriver.ISeleniumDriver;
import SeleniumDriver.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Login
{
    private ISeleniumDriver driver;

    private final String MAIL = "your_mail_address@gmail.com";
    private final String PASSWORD = "your_password";

    private final String INVALID_MAIL = "qwerty_35sLX@gmail.com";
    private final String INVALID_PASSWORD = "this'sRand0mpass?#'^";

    private final String LOGIN_USERNAME_ID = "username";
    private final String LOGIN_PASSWORD_ID = "password";
    private final String ENTER_LOGIN_CSS_SELECTOR = "#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > button";


    public Login(ISeleniumDriver driver)
    {
        this.driver = driver;
    }

    public ISeleniumDriver getDriver() {
        return driver;
    }

    public boolean login(String email, String password)
    {
        try
        {
            driver.sendKeys(By.id(LOGIN_USERNAME_ID),email);
            driver.sendKeys(By.id(LOGIN_PASSWORD_ID),password);
            driver.waitAndClick(By.cssSelector(ENTER_LOGIN_CSS_SELECTOR),10);


            if (driver.findElement(By.className("woocommerce-error")) == null)
                throw new NoSuchElementException("UNSUCCESSFUL LOGIN");
            else return false;
        }
        catch (NoSuchElementException e)
        {
            System.out.println(e.getMessage());
            return true;
        }

    }
    private void successfulLogin()
    {
       driver.sendKeys(By.id(LOGIN_USERNAME_ID),MAIL);
       driver.sendKeys(By.id(LOGIN_PASSWORD_ID),PASSWORD);
        driver.waitAndClick(By.cssSelector(ENTER_LOGIN_CSS_SELECTOR),10);

    }


  public void run()
  {
      successfulLogin();
  }

    public static void main(String[] args) {
        Login l = new Login(new SeleniumDriver(Constants.LOGIN_PAGE_URL));
        l.successfulLogin();
    }

}
