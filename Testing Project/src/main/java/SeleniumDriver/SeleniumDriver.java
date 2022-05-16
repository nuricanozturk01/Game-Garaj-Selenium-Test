package SeleniumDriver;

import Constants.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class SeleniumDriver implements ISeleniumDriver
{

    private WebDriver driver;
    private String url;


    public SeleniumDriver(String url)
    {
        this.url = url;
        System.setProperty(Constants.DRIVER_NAME,Constants.DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments(Constants.MAXIMIZE_WINDOW);
        options.addArguments(Constants.WHITE_LISTED);
        driver = new ChromeDriver(options);
        driver.get(url);

    }

    @Override
    public void click(By link)
    {
        findElement(link).click();
    }

    @Override
    public void sendKeys(By by, String str)
    {
        WebElement element = findElement(by);
        element.sendKeys(str);
    }


    @Override
    public WebElement findElement(By by)
    {

        WebElement x = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", x);
        return x;
    }

    @Override
    public List<WebElement> findElements(By by)
    {
        return driver.findElements(by);
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }



    @Override
    public void waitAndClick(By by, int time)
    {
        new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(by)).click();
    }

}
