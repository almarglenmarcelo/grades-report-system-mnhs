package system.gradereports.mnhs.forms.quarterlyrating.fourth_quarter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFourthQuarterRepository extends JpaRepository<FourthQuarter, Long> {


    @Query(value = "SELECT * FROM fourth_quarter WHERE id = ?1", nativeQuery = true)
    FourthQuarter findPriorRecord(Long recordId);

    @Query(value = "SELECT * FROM fourth_quarter WHERE student_id = ?1 AND subject_id = ?2", nativeQuery = true)
    FourthQuarter findPriorRecordByStudentIdAndSubjectId(Long studentId, Long subjectId);
}
