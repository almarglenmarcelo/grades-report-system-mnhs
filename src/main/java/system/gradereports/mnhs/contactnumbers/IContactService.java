package system.gradereports.mnhs.contactnumbers;

import org.springframework.http.ResponseEntity;

public interface IContactService {

    ResponseEntity<Object> addContactNumber(Contact contact);
}
