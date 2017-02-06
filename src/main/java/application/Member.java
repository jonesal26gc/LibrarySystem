package application;

import java.util.Date;

public class Member {
    private int number = 0;
    private String surname;
    private String firstName;
    private Address address;
    private Date dateOfBirth;
    private boolean active;
    private Date createDate;
    private Date modifiedDate;
    private Gender gender;

    public Member(String surname, String firstName, Address address, Date dateOfBirth, Gender gender) {
        this.surname = surname;
        this.firstName = firstName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.active = true;
        this.createDate = new Date();
        this.gender = gender;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (number != member.number) return false;
        if (active != member.active) return false;
        if (surname != null ? !surname.equals(member.surname) : member.surname != null) return false;
        if (firstName != null ? !firstName.equals(member.firstName) : member.firstName != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(member.dateOfBirth) : member.dateOfBirth != null)
            return false;
        return gender == member.gender;
    }

    @Override
    public String toString() {
        return "application.Member{" +
                "number=" + number +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address=" + address +
                ", dateOfBirth=" + dateOfBirth +
                ", active=" + active +
                ", createDate=" + createDate +
                ", modifiedDate=" + modifiedDate +
                ", gender=" + gender +
                '}';
    }
}
