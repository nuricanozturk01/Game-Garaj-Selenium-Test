package Page;

import Person.*;
import SeleniumDriver.ISeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

public class Payment
{
    private ISeleniumDriver driver;


    private final By paymentPage = By.cssSelector(".checkout-button.button.alt.wc-forward");
    private final By cartIcon = By.className("edgtf-cart-icon");
    private final By identityNumber = By.id("shipping_tc");
    private final By name = By.id("billing_first_name");
    private final By surname = By.id("billing_last_name");
    private final By address = By.id("billing_address_1");
    private final By postalCode = By.id("billing_postcode");
    private final By smallCity = By.id("billing_city");
    private final By cityTextBox = By.className("select2-search__field");
    private final By telephone = By.id("billing_phone");
    private final By creditCardName = By.id("grilabs_woocommerce_pos-card-holder");
    private final By creditCardNumber = By.id("grilabs_woocommerce_pos-card-number");
    private final By creditCardExpiry = By.id("grilabs_woocommerce_pos-card-expiry");
    private final By creditCardCvc = By.id("grilabs_woocommerce_pos-card-cvc");

    private final By condition1 = By.id("terms");
    private final By condition2 = By.name("intense_obf_onay_checkbox");
    private final By condition3 = By.name("intense_mss_onay_checkbox");

    private final By orderBtn = By.cssSelector("#place_order");

    public Payment(ISeleniumDriver driver)
    {
        this.driver = driver;
    }


    public void fillAddress(Person person)
    {
        driver.sendKeys(identityNumber,person.getId());
        driver.sendKeys(name,person.getName());
        driver.sendKeys(surname,person.getSurname());
        driver.sendKeys(address,person.getAddress().getAddress());
        driver.sendKeys(postalCode,person.getAddress().getPostalCode());
        driver.sendKeys(smallCity,person.getAddress().getSmallCity());
        driver.sendKeys(telephone,person.getTelephone());
        driver.click(By.id("select2-billing_state-container"));
        driver.findElement(cityTextBox).sendKeys(person.getAddress().getRealCity());
        driver.findElement(cityTextBox).sendKeys(Keys.ENTER);

    }

    public void fillCreditCard(Person person)
    {

        String[] expiry = person.getCreditCard().getDividedExpiry();
        String[] number = person.getCreditCard().getDividedCreditCard();
        driver.sendKeys(creditCardName,person.getCreditCard().getCreditCardName());
        driver.sendKeys(creditCardNumber,number[0]);
        driver.sendKeys(creditCardNumber,number[1]);
        driver.sendKeys(creditCardNumber,number[2]);
        driver.sendKeys(creditCardNumber,number[3]);
        driver.sendKeys(creditCardExpiry,expiry[0]);
        driver.sendKeys(creditCardExpiry,expiry[1]);
        driver.sendKeys(creditCardCvc,person.getCreditCard().getCreditCardCvc());
    }

    public void clearAll()
    {
        try
        {
            Thread.sleep(4000);
            driver.findElement(identityNumber).clear();
            driver.findElement(name).clear();
            driver.findElement(surname).clear();
            driver.findElement(address).clear();
            driver.findElement(postalCode).clear();
            driver.findElement(smallCity).clear();
            driver.findElement(telephone).clear();
            driver.findElement(creditCardName).clear();
            driver.findElement(creditCardNumber).clear();
            driver.findElement(creditCardExpiry).clear();
            driver.findElement(creditCardCvc).clear();
            Thread.sleep(4000);

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }


    }
    public void clickButton()
    {
        driver.click(orderBtn);
    }

    // If error return false
    public boolean getStatus()
    {
        try
        {
            if ((driver.findElement(By.className("woocommerce-error"))) != null)
                throw new NoSuchElementException("ERROR!");
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }
    public void goPaymentPage()
    {
        driver.click(cartIcon);
        driver.click(paymentPage);
    }

    public void fillTheBlanks(Person person)
    {
        clearAll();
        fillAddress(person);
        fillCreditCard(person);
    }

    public void acceptCondition()
    {
        try
        {
            Thread.sleep(000);
            driver.waitAndClick(condition1,10);
            driver.waitAndClick(condition2,10);
            driver.waitAndClick(condition3,10);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }
    public void clearConditions()
    {
        try
        {
            Thread.sleep(8000);
            driver.waitAndClick(condition2,10);
            driver.waitAndClick(condition3,10);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }
    public void isAcceptConditions(boolean isAccept)
    {
        clearConditions();
        if (isAccept)
            acceptCondition();
    }


    public void run(Person person, boolean isAccept)
    {
        goPaymentPage();
        fillTheBlanks(person);
        isAcceptConditions(isAccept);
        clickButton();
        System.out.println(getStatus());
    }




}
