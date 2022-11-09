package system.gradereports.mnhs.departments;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.gradereports.mnhs.departments.IDepartmentService;

import java.util.HashMap;

@RestController
@RequestMapping("api/v1/departments")
@AllArgsConstructor
public class DepartmentController {

    private IDepartmentService departmentService;


    @PostMapping
    public ResponseEntity<Object> addDepartment(@RequestBody  HashMap<String, Object> data){
        return departmentService.addDepartment(data);
    }


}
