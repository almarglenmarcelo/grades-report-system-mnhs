package system.gradereports.mnhs.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT * FROM students WHERE lrn = ?1", nativeQuery = true)
    Student findPriorStudent(String lrn);



}
