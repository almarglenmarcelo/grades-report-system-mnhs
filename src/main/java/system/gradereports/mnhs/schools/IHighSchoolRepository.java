package system.gradereports.mnhs.schools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHighSchoolRepository extends JpaRepository<HighSchool, Long> {
}
