package system.gradereports.mnhs.teachers;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public interface ITeacherService {

    ResponseEntity<Object> addTeacher(HashMap<String, Object> data);
    ResponseEntity<Object> setDepartment(HashMap<String, Object> data);

    Teacher getTeacherById(Long teacherId);
    ResponseEntity<Object> getAllTeachers();
}
