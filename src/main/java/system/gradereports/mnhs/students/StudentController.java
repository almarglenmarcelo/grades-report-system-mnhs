package system.gradereports.mnhs.students;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/students")
public class StudentController {

    private IStudentService studentService;


    @PostMapping("/form1")
    public ResponseEntity<Object> generateForm1(@RequestBody HashMap<String, Object> data){

        studentService.prepareDetails(data);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
