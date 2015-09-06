package ua.burdyga.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    @OneToOne
    @JoinColumn(name = "VEHICLE_ID")
    private Vehicle vehicle;

    @OneToMany
    @JoinTable(name = "USER_LAPOP", joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "LAPTOP_ID"))
    private Collection<Laptop> laptops = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
    private Collection<Address> addressList = new ArrayList<>();

    public Collection<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(Collection<Laptop> laptops) {
        this.laptops = laptops;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

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

    public Collection<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(Collection<Address> addressList) {
        this.addressList = addressList;
    }
}
