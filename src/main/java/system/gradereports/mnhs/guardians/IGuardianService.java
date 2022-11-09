package system.gradereports.mnhs.guardians;

import org.springframework.http.ResponseEntity;

public interface IGuardianService {

    ResponseEntity<Object> addGuardian(Guardian guardian);
}
