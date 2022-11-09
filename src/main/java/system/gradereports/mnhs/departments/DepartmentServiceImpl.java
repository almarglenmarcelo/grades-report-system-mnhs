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
        String departmentName = data.get("departmentName").toString();
        Department department = new Department(departmentName);

        departmentRepository.save(department);
        return ResponseEntity.ok(HttpStatus.CREATED);
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
