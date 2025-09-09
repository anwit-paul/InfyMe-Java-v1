package devicedata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This is the crucial annotation
public class DeviceSpecs {

    @Id // This is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells JPA to auto-generate the ID
    private Long id;

    private String deviceId;
    private String deviceModel;

    // Getters and Setters (you can generate these in IntelliJ)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceModel() {
        return deviceModel;
    }
    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    // JPA requires a no-arg constructor
    public DeviceSpecs() {
    }
}