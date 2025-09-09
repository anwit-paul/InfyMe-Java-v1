package devicedata.repository; // Create a new 'repository' package

import devicedata.model.DeviceSpecs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceSpecsRepository extends JpaRepository<DeviceSpecs, Long> {
}