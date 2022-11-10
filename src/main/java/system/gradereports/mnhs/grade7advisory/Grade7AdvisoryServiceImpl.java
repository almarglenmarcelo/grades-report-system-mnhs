package system.gradereports.mnhs.grade7advisory;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import system.gradereports.mnhs.grade7sections.Grade7Section;
import system.gradereports.mnhs.grade7sections.IGrade7SectionService;
import system.gradereports.mnhs.teachers.ITeacherService;
import system.gradereports.mnhs.teachers.Teacher;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
@Transactional
@AllArgsConstructor
public class Grade7AdvisoryServiceImpl implements IGrade7AdvisoryService{

    private final IGrade7AdvisoryRepository grade7AdvisoryRepository;
    private final ITeacherService teacherService;
    private final IGrade7SectionService grade7SectionService;
    @Override
    public ResponseEntity<Object> addNewAdvisory(Grade7Advisory grade7Advisory) {
        HashMap<String, Object> response = new HashMap<>();

        grade7AdvisoryRepository.save(grade7Advisory);
        response.put("result", "new_advisory_class_added");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> prepareNewAdvisoryClass(HashMap<String, Object> data) {
        HashMap<String, Object> response = new HashMap<>();

        Teacher teacher = returnTeacher(Long.parseLong(data.get("teacherId").toString()));
        Grade7Section grade7Section = returnGrade7Section(data.get("grade7SectionName").toString());
        String schoolYear = data.get("schoolYear").toString();

        Grade7Advisory grade7Advisory = new Grade7Advisory(teacher, grade7Section, schoolYear);
        addNewAdvisory(grade7Advisory);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
    @Override
    public Teacher returnTeacher(Long teacherId) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        if(teacher == null) {
            return null;
        }
        return teacher;
    }

    @Override
    public Grade7Section returnGrade7Section(String grade7SectionName) {
        Grade7Section grade7Section = grade7SectionService.getSectionByName(grade7SectionName);

        if(grade7Section == null) {
            return null;
        }
        return grade7Section;
    }
}
