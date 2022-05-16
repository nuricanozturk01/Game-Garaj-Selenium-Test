package Person;

public class CreditCard
{
    private String creditCardName;
    private String creditCardNumber;
    private String creditCardExpiry;
    private String creditCardCvc;


    public CreditCard(String creditCardName, String creditCardNumber, String creditCardExpiry, String creditCardCvc)
    {
        this.creditCardName = creditCardName;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExpiry = creditCardExpiry;
        this.creditCardCvc = creditCardCvc;
    }

    public String[] getDividedCreditCard()
    {
        return new String[]{creditCardNumber.substring(0,4),creditCardNumber.substring(4,8),
                creditCardNumber.substring(8,12),creditCardNumber.substring(12)};
    }
    public String[] getDividedExpiry()
    {
        String month = creditCardExpiry.substring(0,2);
        String year = creditCardExpiry.substring(2);
        return new String[]{month, year};
    }
    @Override
    public String toString() {
        return "Person.CreditCard{" +
                "creditCardName='" + creditCardName + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", creditCardExpiry='" + creditCardExpiry + '\'' +
                ", creditCardCvc='" + creditCardCvc + '\'' +
                '}';
    }

    public String getCreditCardName() {
        return creditCardName;
    }


    public String getCreditCardCvc() {
        return creditCardCvc;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
