import Constants.Constants;
import SeleniumDriver.ISeleniumDriver;
import SeleniumDriver.SeleniumDriver;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import Constants.*;
import java.util.ArrayList;

public class MainPageTest extends TestCase
{
    private static MainPage mainPage;
    private static ISeleniumDriver driver;



    private ArrayList<Double> gamingNotebookPrices;
    private ArrayList<Double> desktopComputerPrices;

    @BeforeAll
    public static void init()
    {
        driver = new SeleniumDriver(Constants.LOGIN_PAGE_URL);
        mainPage = new MainPage(driver);
        mainPage.getLoginPage().run();
    }


    @Test
    public void isSortedGamingNotebooks()
    {

        mainPage.getGamingNoteBook().run();
        gamingNotebookPrices = mainPage.getGamingNoteBook().getGamingNotebookPrices();
        assertTrue(Utility.isSortedMinToMax(gamingNotebookPrices));
    }

    @Test
    public void isSortedDesktopComputers()
    {
        mainPage.getDesktopComputer().run();
        desktopComputerPrices = mainPage.getDesktopComputer().getDesktopComputerPrices();
        boolean b = Utility.isSortedMaxToMin(desktopComputerPrices);
        assertFalse(b);
    }


}