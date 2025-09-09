package devicedata.controller;

import devicedata.model.DeviceSpecs;
import devicedata.repository.DeviceSpecsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceSpecsController {

    private final DeviceSpecsRepository deviceSpecsRepository;

    // Use constructor injection to get the repository instance
    public DeviceSpecsController(DeviceSpecsRepository deviceSpecsRepository) {
        this.deviceSpecsRepository = deviceSpecsRepository;
    }

    @PostMapping("/api/device-specs")
    public String receiveDeviceSpecs(@RequestBody DeviceSpecs specs) {
        // Save the received data to the database
        deviceSpecsRepository.save(specs);

        System.out.println("Received and saved device data for Device ID: " + specs.getDeviceId());
        System.out.println("Received and saved device data for Device Name: " + specs.getDeviceModel());

        return "Device specs received and stored successfully!";
    }
}
