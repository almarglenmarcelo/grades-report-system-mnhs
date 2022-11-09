package system.gradereports.mnhs.grade10sections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGrade10SectionsRepository extends JpaRepository<Grade10Section, Long> {

}
