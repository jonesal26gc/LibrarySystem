package builders;

import application.Address;
import application.Country;

public final class AddressBuilder {
    private String houseName;
    private String streetNameFirst;
    private String streetNameSecond;
    private String town;
    private String city;
    private String postcode;
    private Country country;

    private AddressBuilder() {
    }

    public static AddressBuilder anAddress() {
        return new AddressBuilder();
    }

    public AddressBuilder withHouseName(String houseName) {
        this.houseName = houseName;
        return this;
    }

    public AddressBuilder withStreetNameFirst(String streetNameFirst) {
        this.streetNameFirst = streetNameFirst;
        return this;
    }

    public AddressBuilder withStreetNameSecond(String streetNameSecond) {
        this.streetNameSecond = streetNameSecond;
        return this;
    }

    public AddressBuilder withTown(String town) {
        this.town = town;
        return this;
    }

    public AddressBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder withPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public AddressBuilder withCountry(Country country) {
        this.country = country;
        return this;
    }

    public Address build() {
        Address address = new Address(houseName, streetNameFirst, streetNameSecond, town, city, postcode, country);
        return address;
    }
}
