package system.gradereports.mnhs.subjects;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/subjects")
public class SubjectController {

    private final ISubjectService subjectService;


    @PostMapping
    public ResponseEntity<Object> addSubject(@RequestBody HashMap<String, Object> data){
        String subjectName = data.get("subjectName").toString();
        return subjectService.addSubject(subjectName);
    }
}
