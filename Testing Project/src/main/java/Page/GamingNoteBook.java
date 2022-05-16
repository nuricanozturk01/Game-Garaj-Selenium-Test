package Page;

import SeleniumDriver.ISeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GamingNoteBook
{
    private ISeleniumDriver driver;

    private final By productsPage = By.cssSelector(".no_link .item_text");
    private final By gamingComputersInMenu = By.cssSelector("#nav-menu-item-117725 > a .item_text");
    private final By gamingNotebookLinkText = By.linkText("Taşınabilir Bilgisayar");
    private final By cheapestProduct= By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div[3]/ul/li[1]/div[2]/h2/a");
    private final By addToCart= By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/div/form/div[15]/div/div[5]/button");

    private final By priceClassInAProduct = By.className("price");
    private final By classOfProductList = By.className("edgtf-pl-main-holder");
    private final By listOfProducts = By.tagName("li");

    private ArrayList<Double> gamingNotebookPrices;


    public GamingNoteBook(ISeleniumDriver driver)
    {
        this.driver = driver;
        gamingNotebookPrices = new ArrayList<>();
    }

    public ArrayList<Double> getGamingNotebookPrices()
    {
        return gamingNotebookPrices;
    }

    public void listGamingNotebooks()
    {
        try
        {
            driver.click(productsPage);
            driver.waitAndClick(gamingComputersInMenu,20);
            driver.waitAndClick(gamingNotebookLinkText,20);
        }
        catch (TimeoutException e)
        {
            System.err.println("I cannot click the link. Please wait!");
        }
    }
    private void sortMinToMax()
    {
        driver.getDriver().get(driver.getDriver().getCurrentUrl()+"?orderby=price");
    }

    private void addCart()
    {
        try
        {
            driver.waitAndClick(cheapestProduct,80);
            driver.waitAndClick(addToCart,10);
        }
        catch (TimeoutException e)
        {
            System.out.println("I cannot click the link. Please wait!");
            System.exit(1);
        }

    }

    public void getMinToMaxSortedData()
    {
        WebElement e = driver.findElement(classOfProductList);

        List<WebElement> products = e.findElements(listOfProducts);

        for (int i = 0, j = 1; i < products.size(); ++i,++j)
        {
            WebElement h = products.get(i).findElement(priceClassInAProduct);
            WebElement k = h.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div[3]/ul/li["+j+"]/span/ins/span")); // Price Path Of Product
            String str = k.findElements(By.tagName("bdi")).get(0).getText(); // Price first element in bdi tagname.
            double price = Double.parseDouble(str.split(" ")[0].replace(",","."));
            gamingNotebookPrices.add(price);
        }
        //gamingNotebookPrices.forEach(System.out :: println);
    }


    public void run()
    {
        listGamingNotebooks();
        sortMinToMax();
        getMinToMaxSortedData();
        addCart();
    }


}
