import Constants.Constants;
import SeleniumDriver.ISeleniumDriver;
import SeleniumDriver.SeleniumDriver;

public class Application
{
    public static void run()
    {
        ISeleniumDriver driver = new SeleniumDriver(Constants.LOGIN_PAGE_URL);
        IMainPage startAutomation = new MainPage(driver);
        startAutomation.runAutomation();
    }
}
