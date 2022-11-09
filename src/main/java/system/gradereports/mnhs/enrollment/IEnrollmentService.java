package system.gradereports.mnhs.enrollment;

import org.springframework.http.ResponseEntity;
import system.gradereports.mnhs.students.Student;

import java.util.HashMap;

public interface IEnrollmentService {


    ResponseEntity<Object> enrollStudentAsGrade7(HashMap<String, Object> data);

    ResponseEntity<Object> enrollStudentAsGrade8(Student student);

    ResponseEntity<Object> enrollStudentAsGrade9(Student student);

    ResponseEntity<Object> enrollStudentAsGrade10(Student student);
}
