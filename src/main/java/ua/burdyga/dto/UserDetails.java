package ua.burdyga.dto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    @ElementCollection
    private Set<Address> addressList = new HashSet<>();

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME")),
//            @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME")),
//            @AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME")),
//            @AttributeOverride(name = "zipCode", column = @Column(name = "HOME_ZIP_NAME"))})
//    private Address homeAddress;
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "street", column = @Column(name = "OFFICE_STREET_NAME")),
//            @AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY_NAME")),
//            @AttributeOverride(name = "state", column = @Column(name = "OFFICE_STATE_NAME")),
//            @AttributeOverride(name = "zipCode", column = @Column(name = "OFFICE_ZIP_NAME"))})
//    private Address officeAddress;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(Set<Address> addressList) {
        this.addressList = addressList;
    }
}
