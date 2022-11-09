package system.gradereports.mnhs.teachers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import system.gradereports.mnhs.departments.Department;
import system.gradereports.mnhs.departments.IDepartmentService;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class TeacherServiceImpl implements ITeacherService{

    private ITeacherRepository teacherRepository;

    private IDepartmentService departmentService;

    @Override
    public ResponseEntity<Object> addTeacher(HashMap<String, Object> data) {
        HashMap<String, Object> response = new HashMap<>();

        String firstName = data.get("firstName").toString();
        String middleName = data.get("middleName").toString();
        String lastName = data.get("lastName").toString();
        String departmentName = data.get("departmentName").toString();
        Department department = departmentService.getDepartmentByName(departmentName);

        if(department == null) {
            Department newDepartment = new Department(departmentName);
            departmentService.addOtherDepartment(newDepartment);
            department = departmentService.getDepartmentByName(newDepartment.getName());
        }

        Teacher teacher = new Teacher(firstName, middleName, lastName, department);
        teacherRepository.save(teacher);
        response.put("result", "teacher_created_successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        return teacherRepository.getTeacherById(teacherId);
    }

    @Override
    public ResponseEntity<Object> setDepartment(HashMap<String, Object> data) {
        HashMap<String, Object> response = new HashMap<>();

        String departmentName = data.get("departmentName").toString();
        String teacherId = data.get("teacherId").toString();

        Teacher teacher = teacherRepository.getTeacherById(Long.parseLong(teacherId));
        Department department = departmentService.getDepartmentByName(departmentName);
        teacher.setDepartment(department);


        teacherRepository.save(teacher);

        response.put("result", "teacher_added_to_department");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
