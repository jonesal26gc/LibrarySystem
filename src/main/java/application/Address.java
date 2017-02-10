package application;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="ADDRESS")
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="ADDRESS_ID")
    private int id;

    @Column(name="HOUSE_NAME")
    private String houseName;

    @Column(name="STREET_NAME_FIRST")
    private String streetNameFirst;

    @Column(name="STREET_NAME_SECOND")
    private String streetNameSecond;

    @Column(name="TOWN")
    private String town;

    @Column(name="CITY")
    private String city;

    @Column(name="POSTCODE")
    private String postcode;

    @Column(name="COUNTRY")
    private Country country;

    @Column(name="CREATE_TIMESTAMP")
    private Timestamp createTimestamp;

    @Column(name="MODIFIED_TIMESTAMP")
    private Timestamp modifiedTimestamp;

    public Address(String houseName, String streetNameFirst, String streetNameSecond, String town, String city,
                   String postcode, Country country) {
        this.houseName = houseName;
        this.streetNameFirst = streetNameFirst;
        this.streetNameSecond = streetNameSecond;
        this.town = town;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Timestamp getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Timestamp createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Timestamp getModifiedTimestamp() {
        return modifiedTimestamp;
    }

    public void setModifiedTimestamp(Timestamp modifiedTimestamp) {
        this.modifiedTimestamp = modifiedTimestamp;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", houseName='" + houseName + '\'' +
                ", streetNameFirst='" + streetNameFirst + '\'' +
                ", streetNameSecond='" + streetNameSecond + '\'' +
                ", town='" + town + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country=" + country +
                ", createTimestamp=" + createTimestamp +
                ", modifiedTimestamp=" + modifiedTimestamp +
                '}';
    }
}
