package Person;

public class Person
{
    private String id;
    private String name;
    private String surname;
    private String telephone;

    private Address address;
    private CreditCard creditCard;

    public Person(String id, String name, String surname, String telephone)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;

    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public void setCreditCard(CreditCard creditCard)
    {
        this.creditCard = creditCard;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public Address getAddress() {
        return address;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    @Override
    public String toString() {
        return "Person.Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address=" + address +
                ", creditCard=" + creditCard +
                '}';
    }
}
