package system.gradereports.mnhs.contactnumbers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ContactServiceImpl implements IContactService{

    private IContactRepository contactRepository;


    @Override
    public ResponseEntity<Object> addContactNumber(Contact contact) {
        contactRepository.save(contact);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
