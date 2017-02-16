package application.model;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/*************************************************
 * This is the MODEL for HIBERNATE access to the
 * MEMBER table.
 *
 * It has a foreign key to the ADDRESS table.
 */
@Entity
@Table(name="MEMBER")
public class Member {

    // generate the unique from the "hibernate_sequences" table on the database.
    // The specific key for the sequence row is identified.
    @TableGenerator(
            name = "MemberIdGen",               // name of this generator.
            initialValue = 0,                   // starting value if the row is not already present.
            allocationSize = 1,                 // increment.
            table = "hibernate_sequences",      // table name for sequences.
            pkColumnName = "sequence_name",     // 'key' column name.
            valueColumnName = "next_val",       // 'next value' column name.
            pkColumnValue = "MEMBER_ID")        // key value for this row.

    // Unique key.
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "MemberIdGen")
    @Column(name = "MEMBER_ID")
    private int member_id;

    @Column(name = "SURNAME")
    @NotNull                                    // Not null mean must correspond to the database requirement.
    private String surname;

    @Column(name = "FORENAME")
    @NotNull
    private String forename;

    @OneToOne(cascade = CascadeType.ALL)        // Cascading delete occurs in HIBERNATE when parent is removed.
    @JoinColumn(name="ADDRESS_ID")              // This is the foreign key to the ADDRESS table.
    private Address address;

    @Column(name = "DATE_OF_BIRTH")
    @NotNull
    private Date dateOfBirth;

    @Column(name = "GENDER_CODE")
    @NotNull
    private String genderCode;

    @Column(name = "ACTIVE_INDICATOR")
    @Type(type = "true_false")                  // This translates ENUM to true/false CHAR(1) on the database table.
    @NotNull
    private boolean active = true;

    @Column(name = "CREATED_TIMESTAMP")
    @NotNull
    private Date createDate = new Date();

    @Column(name = "MODIFIED_TIMESTAMP")
    @NotNull
    private Date modifiedDate;

    public Member(int member_id, String surname, String forename, Address address, Date dateOfBirth, String genderCode) {
        this.member_id = member_id;
        this.surname = surname;
        this.forename = forename;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.genderCode = genderCode;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getMember_id() {
        return member_id;
    }

    public String getSurname() {
        return surname;
    }

    public String getForename() {
        return forename;
    }

    public Address getAddress() {
        return address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGenderCode() {
        return genderCode;
    }

    public boolean isActive() {
        return active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "member_id=" + member_id +
                ", surname='" + surname + '\'' +
                ", forename='" + forename + '\'' +
                ", address=" + address +
                ", dateOfBirth=" + dateOfBirth +
                ", active=" + active +
                ", createDate=" + createDate +
                ", modifiedDate=" + modifiedDate +
                ", genderCode='" + genderCode + '\'' +
                '}';
    }
}
