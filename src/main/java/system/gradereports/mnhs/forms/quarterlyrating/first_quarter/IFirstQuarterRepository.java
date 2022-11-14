package system.gradereports.mnhs.forms.quarterlyrating.first_quarter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFirstQuarterRepository extends JpaRepository<FirstQuarter, Long> {


    @Query(value = "SELECT * FROM first_quarter WHERE id = ?1", nativeQuery = true)
    FirstQuarter findPriorRecord(Long recordId);

    @Query(value = "SELECT * FROM first_quarter WHERE student_id = ?1 AND subject_id = ?2", nativeQuery = true)
    FirstQuarter findPriorRecordByStudentIdAndSubjectId(Long studentId, Long subjectId);
}
