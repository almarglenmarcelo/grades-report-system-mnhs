package system.gradereports.mnhs.students;

import org.springframework.http.ResponseEntity;
import system.gradereports.mnhs.ethnicgroups.EthnicGroup;
import system.gradereports.mnhs.grade7sections.Grade7Section;
import system.gradereports.mnhs.religions.Religion;

import java.util.HashMap;

public interface IStudentService {

    ResponseEntity<Object> addGrade7Student(Student student);

    Student findStudentByLrn(String lrn);
}
