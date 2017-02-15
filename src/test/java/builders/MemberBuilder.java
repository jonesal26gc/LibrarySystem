package builders;

import application.Address;
import application.Gender;
import application.Member;

import java.util.Date;

public final class MemberBuilder {
    private String surname;
    private String firstName;
    private Address address;
    private Date dateOfBirth;
    private Gender gender;

    private MemberBuilder() {
    }

    public static MemberBuilder aMember() {
        return new MemberBuilder();
    }

    public MemberBuilder withSurname(String surname) {
        if (surname.equals("")) {
            retrieveRandomSurname();
            retrieveRandomFirstName();
            retrieveRandomDateOfBirth();
            return this;
        }
        this.surname = surname;
        return this;
    }

    private void retrieveRandomDateOfBirth() {
        this.dateOfBirth = new Date(
                ((int) Math.round(Math.random() * 30) + 80),
                ((int) Math.round(Math.random() * 11) + 1),
                ((int) Math.round(Math.random() * 27) + 1));
    }

    private void retrieveRandomSurname() {
        switch (((int) Math.round(Math.random() * 9)) + 1) {
            case 1:
                this.surname = "Jones";
                break;
            case 2:
                this.surname = "Phillips";
                break;
            case 3:
                this.surname = "Clarke";
                break;
            case 4:
                this.surname = "Hill";
                break;
            case 5:
                this.surname = "Smith";
                break;
            case 6:
                this.surname = "Read";
                break;
            case 7:
                this.surname = "Menzies";
                break;
            case 8:
                this.surname = "Walker";
                break;
            case 9:
                this.surname = "Stevens";
                break;
            default:
            case 10:
                this.surname = "Durley";
        }
    }

    private void retrieveRandomFirstName() {
        switch (((int) Math.round(Math.random() * 9)) + 1) {
            case 1:
                this.firstName = "Sally";
                this.gender = Gender.FEMALE;
                break;
            case 2:
                this.firstName = "Michael";
                this.gender = Gender.MALE;
                break;
            case 3:
                this.firstName = "Robert";
                this.gender = Gender.MALE;
                break;
            case 4:
                this.firstName = "Steve";
                this.gender = Gender.MALE;
                break;
            case 5:
                this.firstName = "Rodney";
                this.gender = Gender.MALE;
                break;
            case 6:
                this.firstName = "Paula";
                this.gender = Gender.FEMALE;
                break;
            case 7:
                this.firstName = "Simon";
                this.gender = Gender.MALE;
                break;
            case 8:
                this.firstName = "Chris";
                this.gender = Gender.MALE;
                break;
            case 9:
                this.firstName = "John";
                this.gender = Gender.MALE;
                break;
            default:
            case 10:
                this.firstName = "Richard";
                this.gender = Gender.MALE;
        }
    }

    public MemberBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
    }

    public MemberBuilder withAddress(Address address) {
        this.address = address;
        return this;
    }

    public MemberBuilder withDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public MemberBuilder withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Member build() {
        return new Member(surname, firstName, address, dateOfBirth, gender);
    }
}
