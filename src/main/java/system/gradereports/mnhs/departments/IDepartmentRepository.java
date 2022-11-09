package system.gradereports.mnhs.departments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Long> {

    @Query(value = "SELECT * FROM departments WHERE name = ?1", nativeQuery = true)
    Department findDepartmentByName(String name);
}
