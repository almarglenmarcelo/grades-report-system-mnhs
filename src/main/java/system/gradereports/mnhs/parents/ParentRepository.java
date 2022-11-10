package system.gradereports.mnhs.parents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

    @Query(value = "SELECT parents.first_name, parents.middle_name, parents.last_name \n" +
                    "FROM parents \n" +
                    "LEFT JOIN parent_students\n" +
                    "\tON parents.id = parent_students.parent_id \n" +
                    "    WHERE parent_students.student_id = ?1 AND is_male = 1", nativeQuery = true)
    Parent findFatherParentByStudentId(Long studentId);

    @Query(value = "SELECT parents.first_name, parents.middle_name, parents.last_name \n" +
            "FROM parents \n" +
            "LEFT JOIN parent_students\n" +
            "\tON parents.id = parent_students.parent_id \n" +
            "    WHERE parent_students.student_id = ?1 AND is_male = 0", nativeQuery = true)
    Parent findMotherParentByStudentId(Long studentId);


}
