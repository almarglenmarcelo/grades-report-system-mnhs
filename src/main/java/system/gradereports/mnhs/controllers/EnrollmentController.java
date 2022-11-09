package system.gradereports.mnhs.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.gradereports.mnhs.enrollment.IEnrollmentService;

import java.util.HashMap;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/enrollment")
public class EnrollmentController {

    private IEnrollmentService enrollmentService;

    @PostMapping("/grade7")
    public ResponseEntity<Object> enrollGrade7(@RequestBody HashMap<String, Object> data){
        return enrollmentService.enrollStudentAsGrade7(data);
    }
}
