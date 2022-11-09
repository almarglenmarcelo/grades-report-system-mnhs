package system.gradereports.mnhs.departments;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public interface IDepartmentService {

    ResponseEntity<Object> addDepartment(HashMap<String, Object> data);

    Department getDepartmentByName(String name);

    ResponseEntity<Object> addOtherDepartment(Department department);

}
