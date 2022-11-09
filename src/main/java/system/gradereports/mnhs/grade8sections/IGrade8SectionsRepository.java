package system.gradereports.mnhs.grade8sections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGrade8SectionsRepository extends JpaRepository<Grade8Section, Long> {

}
