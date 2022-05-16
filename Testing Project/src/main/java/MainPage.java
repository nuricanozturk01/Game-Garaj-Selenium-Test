import Page.*;
import Person.Person;
import SeleniumDriver.ISeleniumDriver;
import Person.*;
public class MainPage implements IMainPage
{
    private ISeleniumDriver seleniumDriver;

    private Login loginPage;
    private SignUp signUpPage;
    private GamingNoteBook gamingNoteBook;
    private DesktopComputer desktopComputer;
    private Cart cart;
    private Payment paymentPage;

    public MainPage(ISeleniumDriver seleniumDriver)
    {
        this.seleniumDriver = seleniumDriver;

        loginPage = new Login(seleniumDriver);
        signUpPage = new SignUp(seleniumDriver);
        gamingNoteBook = new GamingNoteBook(seleniumDriver);
        desktopComputer = new DesktopComputer(seleniumDriver);
        cart = new Cart(seleniumDriver);
        paymentPage = new Payment(seleniumDriver);
    }

    public Login getLoginPage()
    {
        return loginPage;
    }

    public SignUp getSignUpPage()
    {
        return signUpPage;
    }

    public GamingNoteBook getGamingNoteBook()
    {
        return gamingNoteBook;
    }

    public DesktopComputer getDesktopComputer()
    {
        return desktopComputer;
    }

    public Cart getCart()
    {
        return cart;
    }

    public Payment getPaymentPage()
    {
        return paymentPage;
    }

    @Override
    public void login()
    {
        loginPage.run();
    }

    @Override
    public void signUp()
    {
        signUpPage.successfulSignUp();
    }

    @Override
    public void addCartCheapestGamingNotebook()
    {
        gamingNoteBook.run();
    }

    @Override
    public void addCartMostExpensiveDesktopComputer()
    {
        desktopComputer.run();
    }

    @Override
    public void cartPage()
    {
        cart.run();
    }

    @Override
    public void payment()
    {
        Person person = new Person("465415445","John","Wick","3684154658");
        CreditCard creditCard = new CreditCard("JOHN","8743205964105238","1028","374");
        Address address = new Address("Ankara","212gerger","Hatay","Istanbul");
        person.setAddress(address);
        person.setCreditCard(creditCard);
        paymentPage.run(person,true);

    }

    @Override
    public void runAutomation()
    {
        login();
        addCartCheapestGamingNotebook();
        addCartMostExpensiveDesktopComputer();
        cartPage();
        payment();
    }

}
