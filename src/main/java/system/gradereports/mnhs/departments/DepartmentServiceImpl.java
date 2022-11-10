package system.gradereports.mnhs.departments;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
@Transactional
@AllArgsConstructor
public class DepartmentServiceImpl implements IDepartmentService{
    private IDepartmentRepository departmentRepository;
    @Override
    public ResponseEntity<Object> addDepartment(HashMap<String, Object> data) {
        HashMap<String, Object> response = new HashMap<>();
        String departmentName = data.get("departmentName").toString();
        Department department = new Department(departmentName);

        Department priorDepartment = departmentRepository.findDepartmentByName(departmentName);

        if(priorDepartment != null) {
            response.put("result", "department_already_exists");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        departmentRepository.save(department);
        response.put("result", "new_department_added");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> addOtherDepartment(Department department) {
        departmentRepository.save(department);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findDepartmentByName(name.toUpperCase());
    }
}
