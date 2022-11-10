package system.gradereports.mnhs.grade7advisory;

import org.springframework.http.ResponseEntity;
import system.gradereports.mnhs.grade7sections.Grade7Section;
import system.gradereports.mnhs.teachers.Teacher;

import java.util.HashMap;

public interface IGrade7AdvisoryService {

    ResponseEntity<Object> addNewAdvisory(Grade7Advisory grade7Advisory);
    ResponseEntity<Object> prepareNewAdvisoryClass(HashMap<String, Object> data);
    Teacher returnTeacher(Long teacherId);
    Grade7Section returnGrade7Section(String grade7SectionName);


}
