package system.gradereports.mnhs.grade9sections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGrade9SectionsRepository extends JpaRepository<Grade9Section, Long> {

}
