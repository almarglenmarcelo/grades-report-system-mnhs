package system.gradereports.mnhs.students;

import org.springframework.http.ResponseEntity;
import system.gradereports.mnhs.forms.form1.Form1;

import java.util.HashMap;

public interface IStudentService {

    ResponseEntity<Object> addGrade7Student(Student student);
    Student findStudentByLrn(String lrn);
    ResponseEntity<Object> generateForm1(Form1 form1);
    ResponseEntity<Object> prepareDetails(HashMap<String, Object> data);
}
