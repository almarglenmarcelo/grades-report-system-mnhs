package system.gradereports.mnhs.student_addresses;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public interface IAddressService {

    ResponseEntity<Object> addAddress(Address address);


}
