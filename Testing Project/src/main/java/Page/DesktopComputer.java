package Page;

import SeleniumDriver.ISeleniumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;



// If website updated, change the index of locateData and first Product ../li[n]/..
public class DesktopComputer
{
    private ISeleniumDriver driver;
    private JavascriptExecutor js;

    private final By productsPage = By.cssSelector(".no_link .item_text");
    private final By desktopComputersInMenu = By.cssSelector("#nav-menu-item-117725 > a .item_text");
    private final By desktopComputerLinkText = By.linkText("Masaüstü Bilgisayar");
    private final By firstProduct = By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div[3]/ul/li[4]/div[1]/a");
    private final By addCart = By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/div/form/div[17]/div/div[5]/button");

    private final By priceClassInAProduct = By.className("price");
    private final By classOfProductList = By.className("edgtf-pl-main-holder");
    private final By listOfProducts = By.tagName("li");
    private final By nextPage = By.cssSelector(".next.page-numbers");

    private ArrayList<Double> desktopComputerPrices;


    public DesktopComputer(ISeleniumDriver driver)
    {
        this.driver = driver;
        desktopComputerPrices = new ArrayList<>();
        js = (JavascriptExecutor) driver.getDriver();
    }

    public ArrayList<Double> getDesktopComputerPrices()
    {
        return desktopComputerPrices;
    }

    public void listDesktopComputers()
    {
        try
        {

            driver.waitAndClick(productsPage,20);
            driver.waitAndClick(desktopComputersInMenu,20);
            driver.waitAndClick(desktopComputerLinkText,20);
        }
        catch (TimeoutException e)
        {
            System.err.println("I cannot click the link. Please wait!");
        }
    }
    private void sortMaxToMin()
    {
        driver.getDriver().get(driver.getDriver().getCurrentUrl()+"?orderby=price-desc");
    }

    private void addCart()
    {
        try
        {
            driver.click(firstProduct);
            Thread.sleep(5000);
            driver.click(addCart);
            js.executeScript("window.history.go(-2)");
            Thread.sleep(5000);
        }
        catch (TimeoutException e)
        {
            System.err.println("I cannot click the link. Please wait!");
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void locateData()
    {
        for (int i = 0; i < 5; ++i)
        {
            if (i == 0)
                getMaxToMinSortedData(3,3);
            else getMaxToMinSortedData(0,1);

            driver.findElement(nextPage).click();
            new WebDriverWait(driver.getDriver(),100).until( ExpectedConditions.visibilityOfAllElementsLocatedBy(classOfProductList));
        }
        getMaxToMinSortedData(0,1);

    }

    public void getMaxToMinSortedData(int i, int j)
    {
        WebElement e = driver.findElement(classOfProductList);
        List<WebElement> products = e.findElements(listOfProducts);

        for (; i < products.size(); ++i,++j)
        {
            WebElement h = products.get(i).findElement(priceClassInAProduct);
            WebElement k = h.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div[3]/ul/li["+j+"]/span/ins/span"));
            String str = k.findElements(By.tagName("bdi")).get(0).getText();
            double price = Double.parseDouble(str.split(" ")[0].replace(",","."));
            desktopComputerPrices.add(price);
        }

    }


    public void run()
    {
        listDesktopComputers();
        sortMaxToMin();
        addCart();
        locateData();
    }

}
