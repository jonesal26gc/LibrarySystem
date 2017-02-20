package application.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;

/***********************************************
 * This is the MODEL for HIBERNATE access to the
 * ADDRESS table.
 */

@Entity
@Table(name="ADDRESS")
public class Address {
    @TableGenerator(
            name="addressIdGen",
            initialValue = 0,
            allocationSize = 1,
            table="hibernate_sequences",
            pkColumnName="sequence_name",
            valueColumnName="next_val",
            pkColumnValue="ADDRESS_ID")

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "addressIdGen")
    @Column(name="ADDRESS_ID")
    private int address_id;

    @Column(name="BUILDING_NAME")
    private String buildingName;

    @Column(name="STREET_NAME_LINE_1")
    @NotNull
    private String streetNameLine1;

    @Column(name="STREET_NAME_LINE_2")
    private String streetNameLine2;

    @Column(name="TOWN")
    @NotNull
    private String town;

    @NotNull
    @Column(name="CITY")
    private String city;

    @Column(name="POSTCODE")
    @NotNull
    private String postcode;

    @Column(name="COUNTRY")
    @NotNull
    private String country;

    @Column(name="CREATED_TIMESTAMP")
    @NotNull
    private Timestamp createdTimestamp;

    @Column(name="MODIFIED_TIMESTAMP")
    private Timestamp modifiedTimestamp;

    public Address() {
    }

    public Address(int address_id, String streetNameLine1, String town, String city,
                   String postcode, String country) {
        this.address_id = address_id;
        this.streetNameLine1 = streetNameLine1;
        this.town = town;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public String getStreetNameLine1() {
        return streetNameLine1;
    }

    public String getStreetNameLine2() {
        return streetNameLine2;
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

    public String getCountry() {
        return country;
    }

    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Timestamp getModifiedTimestamp() {
        return modifiedTimestamp;
    }

    public void setModifiedTimestamp(Timestamp modifiedTimestamp) {
        this.modifiedTimestamp = modifiedTimestamp;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public void setStreetNameLine2(String streetNameLine2) {
        this.streetNameLine2 = streetNameLine2;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address_id=" + address_id +
                ", buildingName='" + buildingName + '\'' +
                ", streetNameLine1='" + streetNameLine1 + '\'' +
                ", streetNameLine2='" + streetNameLine2 + '\'' +
                ", town='" + town + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country=" + country +
                ", createdTimestamp=" + createdTimestamp +
                ", modifiedTimestamp=" + modifiedTimestamp +
                '}';
    }
}
