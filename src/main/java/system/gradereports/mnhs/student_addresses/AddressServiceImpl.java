package system.gradereports.mnhs.student_addresses;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
@Transactional
@AllArgsConstructor
public class AddressServiceImpl implements IAddressService{

    private IAddressRepository addressRepository;

    @Override
    public ResponseEntity<Object> addAddress(Address address) {

        addressRepository.save(address);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
