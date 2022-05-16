package SeleniumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface ISeleniumDriver
{
    WebDriver getDriver();


    WebElement findElement(By by);

    List<WebElement> findElements(By by);

    void click(By link);
    void sendKeys(By by, String str);
    void waitAndClick(By by, int time);



}
