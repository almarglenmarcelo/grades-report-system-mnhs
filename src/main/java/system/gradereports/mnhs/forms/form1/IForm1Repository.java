package system.gradereports.mnhs.forms.form1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IForm1Repository extends JpaRepository<Form1, Long> {


    @Query(value = "SELECT * FROM form1 WHERE student_id = ?1", nativeQuery = true)
    Form1 findByStudentId(Long studentId);
}
