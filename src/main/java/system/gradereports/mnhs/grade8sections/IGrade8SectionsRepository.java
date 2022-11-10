package system.gradereports.mnhs.grade8sections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import system.gradereports.mnhs.grade7sections.Grade7Section;

@Repository
public interface IGrade8SectionsRepository extends JpaRepository<Grade8Section, Long> {

    @Query(value = "SELECT * FROM grade_8_sections WHERE name = ?1", nativeQuery = true)
    Grade7Section getSectionByName(String name);
}
