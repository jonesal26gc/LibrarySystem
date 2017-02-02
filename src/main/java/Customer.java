import java.util.Date;

public class Customer {
    private String surname;
    private String firstName;
    private Address address;
    private Date dateOfBirth;
    private boolean active;
    private Date createDate;
    private Date modifiedDate;


    public Customer(String surname, String firstName, Address address, Date dateOfBirth) {
        this.surname = surname;
        this.firstName = firstName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.active = true;
        this.createDate = new Date();
        this.modifiedDate = new Date();
    }

    public boolean isActive() {
        return active;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public Address getAddress() {
        return address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
