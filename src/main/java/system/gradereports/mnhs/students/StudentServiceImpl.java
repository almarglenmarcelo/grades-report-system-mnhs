package system.gradereports.mnhs.students;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.gradereports.mnhs.forms.form1.Form1;
import system.gradereports.mnhs.forms.form1.IForm1Service;
import system.gradereports.mnhs.guardians.Guardian;
import system.gradereports.mnhs.parents.IParentService;
import system.gradereports.mnhs.parents.Parent;
import system.gradereports.mnhs.parents.ParentRepository;
import system.gradereports.mnhs.student_addresses.Address;
import system.gradereports.mnhs.student_addresses.IAddressService;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements IStudentService{

    private IStudentRepository studentRepository;
    private IForm1Service form1Service;
    private IAddressService addressService;
    private IParentService parentService;


//    Remove After
    private ParentRepository parentRepository;
    @Override
    public ResponseEntity<Object> addGrade7Student(Student theStudent) {

        studentRepository.save(theStudent);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Override
    public Student findStudentByLrn(String lrn) {
        return studentRepository.findPriorStudent(lrn);
    }

    @Override
    public ResponseEntity<Object> generateForm1(Form1 form1) {
        HashMap<String, Object> response = new HashMap<>();
        form1Service.insertNewForm1(form1);

        response.put("result","form_1_created_successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public void prepareDetails(HashMap<String, Object> data) {

        Long studentId = Long.parseLong(data.get("studentId").toString());
        String schoolYear = data.get("schoolYear").toString();
        String remarks = data.get("remarks").toString();

//        Get Student
        Student priorStudent = studentRepository.findById(studentId).get();

//        Get Address
        Address priorAddress = addressService.getAddressByStudentId(studentId);

//        Get Guardian
        String[] guardianDetails = studentRepository.getGuardianByStudentId(studentId).split(",");
        Long guardianId = Long.parseLong(guardianDetails[0]);
        String firstName = guardianDetails[1].trim();
        String middleName = guardianDetails[2].trim();
        String lastName = guardianDetails[3].trim();
        String relationship = guardianDetails[4].trim();
        Guardian guardian = new Guardian(guardianId, firstName, middleName, lastName, relationship);

        //        Get Parent - Father ID
        String[] fatherDetails = parentService.findFatherParentByStudentId(studentId).split(",");
        Parent father = parseParent(fatherDetails);

//        Get Parent - Mother Id
        String[] motherDetails = parentService.findMotherParentByStudentId(studentId).split(",");
        Parent mother = parseParent(motherDetails);

        Form1 newForm = new Form1(priorStudent, priorAddress, father, mother, guardian, schoolYear, remarks);
        generateForm1(newForm);
    }

    public Parent parseParent(String[] priorParentDetails){

        String[] parentDetails = priorParentDetails;
        Long parentId = Long.parseLong(parentDetails[0]);
        String parentFirstName = parentDetails[1].trim();
        String parentMiddleName = parentDetails[2].trim();
        String parentLastName = parentDetails[3].trim();
        Parent parent = new Parent(parentId, parentFirstName, parentMiddleName,parentLastName);

        return parent;
    }
}
