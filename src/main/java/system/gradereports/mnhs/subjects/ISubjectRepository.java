package system.gradereports.mnhs.subjects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Long> {

    @Query(value = "SELECT * FROM subjects WHERE name = ?1", nativeQuery = true)
    Subject findSubjectByName(String name);
}
