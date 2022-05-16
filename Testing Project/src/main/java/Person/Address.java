package Person;

public class Address
{

    private String address;

    private String postalCode;
    private String smallCity;
    private String realCity;

    public Address(String address, String postalCode, String smallCity, String realCity)
    {
        this.address = address;
        this.postalCode = postalCode;
        this.smallCity = smallCity;
        this.realCity = realCity;
    }


    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getSmallCity() {
        return smallCity;
    }

    public String getRealCity() {
        return realCity;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Person.Address{" +
                "address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", smallCity='" + smallCity + '\'' +
                ", realCity='" + realCity + '\'' +
                '}';
    }
}
