package system.gradereports.mnhs.parents;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ParentServiceImpl implements IParentService{

    private ParentRepository parentRepository;

    @Override
    public ResponseEntity<Object> addParent(Parent parent) {
        parentRepository.save(parent);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
