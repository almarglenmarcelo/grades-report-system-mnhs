package system.gradereports.mnhs.forms.quarterlyrating.fourth_quarter;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import system.gradereports.mnhs.students.IStudentService;
import system.gradereports.mnhs.students.Student;
import system.gradereports.mnhs.subjects.ISubjectService;
import system.gradereports.mnhs.subjects.Subject;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
@Transactional
@AllArgsConstructor
public class FourthQuarterServiceImpl implements IFourthQuarterService {
    private IFourthQuarterRepository fourthQuarterRepository;
    private ISubjectService subjectService;
    private IStudentService studentService;
    private HashMap<String, Object> response;
    @Override
    public ResponseEntity<Object> insertGrade(HashMap<String, Object> data) {
        Student priorStudent = studentService.findStudentByLrn(data.get("lrn").toString());
        Subject priorSubject = subjectService.findSubjectByName(data.get("subjectName").toString().toUpperCase());
        
        if(priorSubject == null) {
            subjectService.addSubject(data.get("subjectName").toString());
            priorSubject = subjectService.findSubjectByName(data.get("subjectName").toString().toUpperCase());
        }

        Long grade = Long.parseLong(data.get("grade").toString());
        FourthQuarter priorRecord = fourthQuarterRepository.findPriorRecordByStudentIdAndSubjectId(priorStudent.getId(), priorSubject.getId());
        if(priorRecord != null) {
            response.put("result", "record_already_inserted");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        response = new HashMap<>();
        response.put("result", "fourth_quarter_inserted");
        fourthQuarterRepository.save(new FourthQuarter(priorSubject, grade, priorStudent));
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
    @Override
    public ResponseEntity<Object> updateGrade(HashMap<String, Object> data) {
        Long recordId = Long.parseLong(data.get("recordId").toString());
        FourthQuarter priorRecord = fourthQuarterRepository.findPriorRecord(recordId);
        Student priorStudent = studentService.findStudentByLrn(data.get("lrn").toString());
        Subject priorSubject = subjectService.findSubjectByName(data.get("subjectName").toString().toUpperCase());
        Long grade = Long.parseLong(data.get("grade").toString());

        response = new HashMap<>();
        response.put("result", "fourth_quarter_updated");
        fourthQuarterRepository.save(new FourthQuarter(priorRecord ,priorSubject, grade, priorStudent));
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
