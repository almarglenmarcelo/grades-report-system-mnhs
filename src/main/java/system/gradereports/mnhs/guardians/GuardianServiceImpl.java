package system.gradereports.mnhs.guardians;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class GuardianServiceImpl implements  IGuardianService{

    private IGuardianRepository guardianRepository;

    @Override
    public ResponseEntity<Object> addGuardian(Guardian guardian) {
        guardianRepository.save(guardian);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
