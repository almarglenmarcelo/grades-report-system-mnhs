package system.gradereports.mnhs.students;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.gradereports.mnhs.ethnicgroups.EthnicGroup;
import system.gradereports.mnhs.grade7sections.Grade7Section;
import system.gradereports.mnhs.religions.Religion;


import java.time.LocalDate;
import java.util.HashMap;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements IStudentService{

    private IStudentRepository studentRepository;

    @Override
    public ResponseEntity<Object> addGrade7Student(Student theStudent) {

        studentRepository.save(theStudent);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Override
    public Student findStudentByLrn(String lrn) {
        return studentRepository.findPriorStudent(lrn);
    }
}
