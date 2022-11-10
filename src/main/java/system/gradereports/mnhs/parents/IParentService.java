package system.gradereports.mnhs.parents;

import org.springframework.http.ResponseEntity;

public interface IParentService {

    ResponseEntity<Object> addParent(Parent parent);

    String findFatherParentByStudentId(Long studentId);

    String findMotherParentByStudentId(Long studentId);

}
