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
            switch (((int) Math.round(Math.random() * 9)) + 1) {
                case 1:
                    this.surname = "Jones";
                    return this;
                case 2:
                    this.surname = "Phillips";
                    return this;
                case 3:
                    this.surname = "Clarke";
                    return this;
                case 4:
                    this.surname = "Hill";
                    return this;
                case 5:
                    this.surname = "Smith";
                    return this;
                case 6:
                    this.surname = "Read";
                    return this;
                case 7:
                    this.surname = "Menzies";
                    return this;
                case 8:
                    this.surname = "Walker";
                    return this;
                case 9:
                    this.surname = "Stevens";
                    return this;
                default:
                case 10:
                    this.surname = "Durley";
                    return this;
            }
        } else {
            this.surname = surname;
            return this;
        }
    }

    public MemberBuilder withFirstName(String firstName) {
        if (firstName.equals("")) {
            switch (((int) Math.round(Math.random() * 9)) + 1) {
                case 1:
                    this.firstName = "Stewart";
                    return this;
                case 2:
                    this.firstName = "Michael";
                    return this;
                case 3:
                    this.firstName = "Robert";
                    return this;
                case 4:
                    this.firstName = "Steve";
                    return this;
                case 5:
                    this.firstName = "Rodney";
                    return this;
                case 6:
                    this.firstName = "Paul";
                    return this;
                case 7:
                    this.firstName = "Simon";
                    return this;
                case 8:
                    this.firstName = "Chris";
                    return this;
                case 9:
                    this.firstName = "John";
                    return this;
                default:
                case 10:
                    this.firstName = "Richard";
                    return this;
            }
        } else {
            this.firstName = firstName;
            this.gender = Gender.MALE;
            return this;
        }
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
        Member member = new Member(surname, firstName, address, dateOfBirth, gender);
        return member;
    }
}
