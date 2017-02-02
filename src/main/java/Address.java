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
}
