package system.gradereports.mnhs.subjects;

import org.springframework.http.ResponseEntity;

public interface ISubjectService {

    ResponseEntity<Object> addSubject(String name);

    Subject findSubjectByName(String name);


}
