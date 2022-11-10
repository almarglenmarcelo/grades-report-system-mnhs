package system.gradereports.mnhs.students;

import lombok.AllArgsConstructor;
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
    public ResponseEntity<Object> gatherInfo(@RequestBody HashMap<String, Object> data){

        return studentService.prepareDetails(data);
    }

}
