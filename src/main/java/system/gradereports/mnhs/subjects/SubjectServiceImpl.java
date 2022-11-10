package system.gradereports.mnhs.subjects;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
@Transactional
@AllArgsConstructor
public class SubjectServiceImpl implements ISubjectService{

    private final ISubjectRepository subjectRepository;

    @Override
    public ResponseEntity<Object> addSubject(String name) {
        HashMap<String, Object> response = new HashMap<>();
        Subject newSubject = new Subject(name);

        Subject priorSubject = findSubjectByName(name);
        if(priorSubject != null) {
            response.put("result", "subject_already_exists");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        subjectRepository.save(newSubject);
        response.put("result", "new_subject_added");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public Subject findSubjectByName(String name) {
        return subjectRepository.findSubjectByName(name.toUpperCase());
    }
}
