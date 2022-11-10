package system.gradereports.mnhs.grade7advisory;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.gradereports.mnhs.teachers.ITeacherService;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/grade7advisory")
public class Grade7AdvisoryController {


    private final IGrade7AdvisoryService grade7AdvisoryService;
    private final ITeacherService teacherService;


    @PostMapping
    public ResponseEntity<Object> prepareAdvisoryClass(@RequestBody HashMap<String, Object> data){

        return grade7AdvisoryService.prepareNewAdvisoryClass(data);
    }
}
