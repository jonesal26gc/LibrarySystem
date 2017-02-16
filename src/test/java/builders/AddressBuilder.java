package builders;

import application.model.Address;
import com.neovisionaries.i18n.CountryCode;

public final class AddressBuilder {
    private int address_id;
    private String buildingName;
    private String streetNameLine1;
    private String streetNameLine2;
    private String town;
    private String city;
    private String postcode;
    private String country;

    private AddressBuilder() {
    }

    public static AddressBuilder anAddress() {
        return new AddressBuilder();
    }

    public AddressBuilder withAddressId(int address_id) {
        this.address_id = address_id;
        return this;
    }

    public AddressBuilder withBuildingName(String buildingName) {
        this.buildingName = buildingName;
        return this;
    }

    public AddressBuilder withStreetNameLine1(String streetNameLine1) {
        if (streetNameLine1.equals("")) {
            retrieveRandomStreetNameLine1();
            return this;
        }
        this.streetNameLine1 = streetNameLine1;
        return this;
    }

    private void retrieveRandomStreetNameLine1() {
        int randomDoorNumber = (int) (Math.round(Math.random() * 199) + 1);
        switch ((int) (Math.round(Math.random() * 9) + 1)) {
            case 1:
                this.streetNameLine1 = String.format("%1$d Grange Close", randomDoorNumber);
                break;
            case 2:
                this.streetNameLine1 = String.format("%1$d Tennyson Avenue", randomDoorNumber);
                break;
            case 3:
                this.streetNameLine1 = String.format("%1$d The Avenue", randomDoorNumber);
                break;
            case 4:
                this.streetNameLine1 = String.format("%1$d Chilton Road", randomDoorNumber);
                break;
            case 5:
                this.streetNameLine1 = String.format("%1$d Newlands Lane", randomDoorNumber);
                break;
            case 6:
                this.streetNameLine1 = String.format("%1$d Priory Way", randomDoorNumber);
                break;
            case 7:
                this.streetNameLine1 = String.format("%1$d Langbridge Close", randomDoorNumber);
                break;
            case 8:
                this.streetNameLine1 = String.format("%1$d Purwell Lane", randomDoorNumber);
                break;
            case 9:
                this.streetNameLine1 = String.format("%1$d Boundary Close", randomDoorNumber);
                break;
            default:
            case 10:
                this.streetNameLine1 = String.format("%1$d St. Michael's Road", randomDoorNumber);
                break;
        }
        this.town = "Hitchin";
        this.city = "Hertfordshire";
        this.postcode = "SG4 ???";
        this.country = CountryCode.GB.getAlpha3();
    }

    public AddressBuilder withStreetNameLine2(String streetNameLine2) {
        this.streetNameLine2 = streetNameLine2;
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
        return new Address(address_id, streetNameLine1, town, city, postcode, country);
    }
}
