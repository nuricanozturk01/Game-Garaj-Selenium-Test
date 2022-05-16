package Page;

import SeleniumDriver.ISeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Cart
{

    /**
     *
     * This class try to increase conunt of product
     */

    private final By cartIcon = By.className("edgtf-cart-icon");
    private final By carTextFieldGamingNotebook = By.name("cart[7c5f46f657376bb078195b4cb11f6b84][qty]");
    private final By carTextFieldDesktopComputer = By.id("quantity_627fbdca57b7b");
    private ISeleniumDriver driver;


    public Cart(ISeleniumDriver driver)
    {
        this.driver = driver;
    }


    public void goCartIcon()
    {
        driver.waitAndClick(cartIcon,30);
    }

    private String getPriceString()
    {
        WebElement h = driver.findElement(By.className("product-subtotal"));
        WebElement k = h.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/form/table/tbody/tr[1]/td[6]/span")); // Price Path Of Product
        return k.findElements(By.tagName("bdi")).get(0).getText(); // Price first element in bdi tagname.
    }

    private boolean isEqual(String before, String after)
    {
        return before.equals(after);
    }
    private WebElement clear(By product)
    {
        WebElement textField = driver.findElement(product);
        textField.sendKeys(Keys.CONTROL + "a");
        textField.sendKeys(Keys.DELETE);
        return textField;
    }
    public boolean increaseCartNumber(By product, String val)
    {
        String before = getPriceString();
        try
        {
            WebElement textField = clear(product);
            Thread.sleep(4000);
            textField.sendKeys(Keys.BACK_SPACE);
            textField.sendKeys(val);
            textField.sendKeys(Keys.ENTER);
            Thread.sleep(7000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        String after = getPriceString();

        if (before.equals(after))
            return false;
        return true;
    }


    public void run()
    {
        goCartIcon();
    }


}
