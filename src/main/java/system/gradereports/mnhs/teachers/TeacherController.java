package system.gradereports.mnhs.teachers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.gradereports.mnhs.departments.Department;

import java.util.HashMap;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/teachers")
public class TeacherController {
    private ITeacherService teacherService;

    @PostMapping
    public ResponseEntity<Object> addTeacher(@RequestBody HashMap<String, Object> data){
        return teacherService.addTeacher(data);
    }
    @PostMapping("/department")
    public ResponseEntity<Object> setDepartment(@RequestBody HashMap<String, Object> data){
        return teacherService.setDepartment(data);
    }
    @GetMapping
    public ResponseEntity<Object> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

}
