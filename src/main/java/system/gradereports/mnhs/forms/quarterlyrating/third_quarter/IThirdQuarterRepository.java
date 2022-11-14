package system.gradereports.mnhs.forms.quarterlyrating.third_quarter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IThirdQuarterRepository extends JpaRepository<ThirdQuarter, Long> {


    @Query(value = "SELECT * FROM third_quarter WHERE id = ?1", nativeQuery = true)
    ThirdQuarter findPriorRecord(Long recordId);

    @Query(value = "SELECT * FROM third_quarter WHERE student_id = ?1 AND subject_id = ?2", nativeQuery = true)
    ThirdQuarter findPriorRecordByStudentIdAndSubjectId(Long studentId, Long subjectId);
}
