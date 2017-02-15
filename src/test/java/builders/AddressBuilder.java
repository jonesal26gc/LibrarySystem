package builders;

import application.Address;
import application.Country;
import com.neovisionaries.i18n.CountryCode;

public final class AddressBuilder {
    private int id;
    private String houseName;
    private String streetNameFirst;
    private String streetNameSecond;
    private String town;
    private String city;
    private String postcode;
    private String country;

    private AddressBuilder() {
    }

    public static AddressBuilder anAddress() {
        return new AddressBuilder();
    }

    public AddressBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public AddressBuilder withHouseName(String houseName) {
        this.houseName = houseName;
        return this;
    }

    public AddressBuilder withStreetNameFirst(String streetNameFirst) {
        if (streetNameFirst.equals("")) {
            int randomDoorNumber = (int) (Math.round(Math.random() * 199) + 1);
            switch ((int) (Math.round(Math.random() * 9) + 1)) {
                case 1:
                    streetNameFirst = String.format("%1$d Grange Close",randomDoorNumber);
                    break;
                case 2:
                    streetNameFirst = String.format("%1$d Tennyson Avenue",randomDoorNumber);
                    break;
                case 3:
                    streetNameFirst = String.format("%1$d The Avenue",randomDoorNumber);
                    break;
                case 4:
                    streetNameFirst = String.format("%1$d Chilton Road",randomDoorNumber);
                    break;
                case 5:
                    streetNameFirst = String.format("%1$d Newlands Lane",randomDoorNumber);
                    break;
                case 6:
                    streetNameFirst = String.format("%1$d Priory Way",randomDoorNumber);
                    break;
                case 7:
                    streetNameFirst = String.format("%1$d Langbridge Close",randomDoorNumber);
                    break;
                case 8:
                    streetNameFirst = String.format("%1$d Purwell Lane",randomDoorNumber);
                    break;
                case 9:
                    streetNameFirst = String.format("%1$d Boundary Close",randomDoorNumber);
                    break;
                default:
                case 10:
                    streetNameFirst = String.format("%1$d St. Michael's Road",randomDoorNumber);
                    break;
            }
            this.houseName="";
            this.streetNameSecond="";
            this.town = "Hitchin";
            this.city = "Hertfordshire";
            this.postcode="";
            this.country = CountryCode.UK.getAlpha3();
            }
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

    public AddressBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public Address build() {
        Address address = new Address(houseName, streetNameFirst, streetNameSecond, town, city, postcode, country);
        return address;
    }
}
