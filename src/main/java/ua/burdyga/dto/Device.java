package ua.burdyga.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Device {
    @Id
    @GeneratedValue
    private int deviceId;
    private String deviceName;
    @ManyToMany(mappedBy = "devices")
    private Collection<UserDetails> userList = new ArrayList<>();

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Collection<UserDetails> getUserList() {
        return userList;
    }

    public void setUserList(Collection<UserDetails> userList) {
        this.userList = userList;
    }
}
