package system.gradereports.mnhs.grade7sections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IGrade7SectionsRepository extends JpaRepository<Grade7Section, Long> {

    @Query(value = "SELECT * FROM grade_7_sections WHERE name = ?1", nativeQuery = true)
    Grade7Section getSectionByName(String name);

}
