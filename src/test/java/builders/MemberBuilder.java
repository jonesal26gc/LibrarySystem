package builders;

import application.model.Address;
import application.enumerators.Gender;
import application.model.Member;

import java.util.Date;

public final class MemberBuilder {
    private int member_id;
    private String surname;
    private String forename;
    private Address address;
    private Date dateOfBirth;
    private String genderCode;

    private MemberBuilder() {
    }

    public static MemberBuilder aMember() {
        return new MemberBuilder();
    }

    public MemberBuilder withSurname(String surname) {
        if (surname.equals("")) {
            retrieveRandomSurname();
            retrieveRandomForename();
            retrieveRandomDateOfBirth();
            return this;
        }
        this.surname = surname;
        return this;
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

    private void retrieveRandomForename() {
        switch (((int) Math.round(Math.random() * 9)) + 1) {
            case 1:
                this.forename = "Sally";
                this.genderCode = Gender.FEMALE.getGenderCode();
                break;
            case 2:
                this.forename = "Michael";
                this.genderCode = Gender.MALE.getGenderCode();
                break;
            case 3:
                this.forename = "Robert";
                this.genderCode = Gender.MALE.getGenderCode();
                break;
            case 4:
                this.forename = "Steve";
                this.genderCode = Gender.MALE.getGenderCode();
                break;
            case 5:
                this.forename = "Rodney";
                this.genderCode = Gender.MALE.getGenderCode();
                break;
            case 6:
                this.forename = "Paula";
                this.genderCode = Gender.FEMALE.getGenderCode();
                break;
            case 7:
                this.forename = "Simon";
                this.genderCode = Gender.MALE.getGenderCode();
                break;
            case 8:
                this.forename = "Chris";
                this.genderCode = Gender.MALE.getGenderCode();
                break;
            case 9:
                this.forename = "John";
                this.genderCode = Gender.MALE.getGenderCode();
                break;
            default:
            case 10:
                this.forename = "Richard";
                this.genderCode = Gender.MALE.getGenderCode();
        }
    }

    private void retrieveRandomDateOfBirth() {
        this.dateOfBirth = new Date(
                ((int) Math.round(Math.random() * 30) + 80),
                ((int) Math.round(Math.random() * 11) + 1),
                ((int) Math.round(Math.random() * 27) + 1));
    }

    public MemberBuilder withForename(String forename) {
            this.forename = forename;
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

    public MemberBuilder withGenderCode(String genderCode) {
        this.genderCode = genderCode;
        return this;
    }

    public Member build() {
        return new Member(member_id, surname, forename, address, dateOfBirth, genderCode);
    }
}
