package system.gradereports.mnhs.forms.form1;


import org.springframework.http.ResponseEntity;

public interface IForm1Service {

    ResponseEntity<Object> insertNewForm1(Form1 form1);

    ResponseEntity<Object> getAllForm1();

    Form1 checkDuplicateByStudentId(Long studentId);


}
