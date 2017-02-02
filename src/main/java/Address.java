public class Address {
    private String houseName;
    private String streetNameFirst;
    private String streetNameSecond;
    private String town;
    private String city;
    private String postcode;
    private Country country;

    public Address(String houseName, String streetNameFirst, String streetNameSecond, String town, String city, String postcode, Country country) {
        this.houseName = houseName;
        this.streetNameFirst = streetNameFirst;
        this.streetNameSecond = streetNameSecond;
        this.town = town;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
    }

    public String getHouseName() {
        return houseName;
    }

    public String getStreetNameFirst() {
        return streetNameFirst;
    }

    public String getStreetNameSecond() {
        return streetNameSecond;
    }

    public String getTown() {
        return town;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseName='" + houseName + '\'' +
                ", streetNameFirst='" + streetNameFirst + '\'' +
                ", streetNameSecond='" + streetNameSecond + '\'' +
                ", town='" + town + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country=" + country +
                '}';
    }
}
