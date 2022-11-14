package system.gradereports.mnhs.forms.quarterlyrating.second_quarter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISecondQuarterRepository extends JpaRepository<SecondQuarter, Long> {


    @Query(value = "SELECT * FROM second_quarter WHERE id = ?1", nativeQuery = true)
    SecondQuarter findPriorRecord(Long recordId);

    @Query(value = "SELECT * FROM second_quarter WHERE student_id = ?1 AND subject_id = ?2", nativeQuery = true)
    SecondQuarter findPriorRecordByStudentIdAndSubjectId(Long studentId, Long subjectId);
}
