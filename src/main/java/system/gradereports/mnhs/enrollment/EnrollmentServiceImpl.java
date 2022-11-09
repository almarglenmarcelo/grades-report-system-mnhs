package system.gradereports.mnhs.enrollment;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import system.gradereports.mnhs.contactnumbers.Contact;
import system.gradereports.mnhs.contactnumbers.IContactService;
import system.gradereports.mnhs.ethnicgroups.EthnicGroup;
import system.gradereports.mnhs.ethnicgroups.IEthnicGroupService;
import system.gradereports.mnhs.grade7sections.Grade7Section;
import system.gradereports.mnhs.grade7sections.IGrade7SectionService;
import system.gradereports.mnhs.guardians.Guardian;
import system.gradereports.mnhs.guardians.IGuardianService;
import system.gradereports.mnhs.parents.IParentService;
import system.gradereports.mnhs.parents.Parent;
import system.gradereports.mnhs.religions.IReligionService;
import system.gradereports.mnhs.religions.Religion;
import system.gradereports.mnhs.student_addresses.Address;
import system.gradereports.mnhs.student_addresses.IAddressService;
import system.gradereports.mnhs.students.IStudentService;
import system.gradereports.mnhs.students.Student;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class EnrollmentServiceImpl implements  IEnrollmentService{

    private IStudentService studentService;
    private IReligionService religionService;
    private IEthnicGroupService ethnicGroupService;
    private IGrade7SectionService grade7SectionService;
    private IAddressService addressService;
    private IParentService parentService;
    private IGuardianService guardianService;
    private IContactService contactService;

    @Override
    public ResponseEntity<Object> enrollStudentAsGrade7(HashMap<String, Object> data) {
        HashMap<String, Object> response = new HashMap<>();

        //Student Details
        String newStudentLRN = data.get("lrn").toString();
        String firstName = data.get("firstName").toString();
        String middleName = data.get("middleName").toString();
        String lastName = data.get("lastName").toString();
        String nameExtension = data.get("nameExtension").toString();
        Boolean isMale = Boolean.parseBoolean(data.get("isMale").toString());
        String birthdate = data.get("birthdate").toString();
        Integer ageAsOfFirstFridayJune = Integer.parseInt(data.get("ageAsOfFirstFridayJune").toString());
        String motherTongue = data.get("motherTongue").toString();

        //Address Details
        String houseNumber = data.get("houseNumber").toString();
        String street = data.get("street").toString();
        String barangay = data.get("barangay").toString();
        String cityMunicipality = data.get("cityMunicipality").toString();
        String province = data.get("province").toString();

        // Parents Father Details
        String fatherFirstName = data.get("fatherFirstName").toString();
        String fatherMiddleName = data.get("fatherMiddleName").toString();
        String fatherLastName = data.get("fatherLastName").toString();

        // Parents Mother Details
        String motherFirstName = data.get("motherFirstName").toString();
        String motherMiddleName = data.get("motherMiddleName").toString();
        String motherLastName = data.get("motherLastName").toString();

        // Guardian Details
        String guardianFirstName = data.get("guardianFirstName").toString();
        String guardianMiddleName = data.get("guardianMiddleName").toString();
        String guardianLastName = data.get("guardianLastName").toString();
        String relationship = data.get("relationship").toString();
        String contactNumber = data.get("contactNumber").toString();

        // Other Details
        String enteredEthnicGroup = data.get("ethnicGroup").toString();
        String enteredReligionName = data.get("religion").toString();
        String enteredGrade7Section = data.get("grade7Section").toString();
        EthnicGroup ethnicGroup = ethnicGroupService.findEthnicGroupByName(enteredEthnicGroup);
        Religion religion = religionService.findReligionByName(enteredReligionName);
        Grade7Section grade7Section = grade7SectionService.getSectionByName(enteredGrade7Section);


        // This checks if Student was already enrolled by his/her LRN
        Student matchedStudent = studentService.findStudentByLrn(newStudentLRN);
        if(matchedStudent != null){
            response.put("result", "student_already_enrolled");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        // This check if ethnic group and religions exists from the existing records, if not, create new record
        if(ethnicGroup == null){
            EthnicGroup newEthnicGroup = new EthnicGroup(enteredEthnicGroup);
            ethnicGroupService.addOtherEthnicGroup(newEthnicGroup);
            ethnicGroup = ethnicGroupService.getLatestRecord();
        }
        if(religion == null){
            Religion newReligion = new Religion(enteredReligionName);
            religionService.addOtherReligion(newReligion);
            religion = religionService.getLatestRecord();
        }
        if(grade7Section == null){
            Grade7Section newGrade7Section = new Grade7Section(enteredGrade7Section);
            grade7SectionService.addOtherSection(newGrade7Section);
            grade7Section = grade7SectionService.getSectionByName(newGrade7Section.getName());
        }

        // Instantiate new Student and save
        Student newStudent = new Student(
                newStudentLRN,
                firstName,
                middleName,
                lastName,
                nameExtension,
                isMale,
                birthdate,
                ageAsOfFirstFridayJune,
                motherTongue,
                ethnicGroup,
                religion,
                grade7Section
        );

        // Instantiate new Address for the New Student and save
        Address newAddress = new Address(houseNumber, street, barangay, cityMunicipality, province, newStudent);

        // Instantiate Father
        Parent father = new Parent(fatherFirstName, fatherMiddleName, fatherLastName, true);
        father.addChild(newStudent);

        // Instantiate Mother
        Parent mother = new Parent(motherFirstName, motherMiddleName, motherLastName, false);
        mother.addChild(newStudent);

        // Instantiate Guardian
        Guardian guardian = new Guardian(guardianFirstName, guardianMiddleName, guardianLastName, relationship);
        guardian.addStudent(newStudent);
        newStudent.setGuardian(guardian);

        // Instantiate Contact number
        Contact contact = new Contact(guardian, contactNumber);

        contactService.addContactNumber(contact);
        studentService.addGrade7Student(newStudent);
        addressService.addAddress(newAddress);
        parentService.addParent(father);
        parentService.addParent(mother);
        guardianService.addGuardian(guardian);

        response.put("result", "grade7_enrolled_successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> enrollStudentAsGrade8(Student student) {
        return null;
    }

    @Override
    public ResponseEntity<Object> enrollStudentAsGrade9(Student student) {
        return null;
    }

    @Override
    public ResponseEntity<Object> enrollStudentAsGrade10(Student student) {
        return null;
    }
}
