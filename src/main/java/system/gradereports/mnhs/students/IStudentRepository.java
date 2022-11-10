package system.gradereports.mnhs.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import system.gradereports.mnhs.guardians.Guardian;

import java.util.List;
import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT * FROM students WHERE lrn = ?1", nativeQuery = true)
    Student findPriorStudent(String lrn);

    @Query(value = "SELECT guardians.first_name, guardians.middle_name, guardians.last_name, guardians.relationship from guardians \n" +
                    "INNER JOIN students\n" +
                    "ON guardians.id = students.guardian_id WHERE students.id = ?1", nativeQuery = true)
    Guardian getGuardianByStudentId(Long studentId);


}
