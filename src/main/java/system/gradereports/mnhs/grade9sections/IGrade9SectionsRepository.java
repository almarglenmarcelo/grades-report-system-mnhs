package system.gradereports.mnhs.grade9sections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import system.gradereports.mnhs.grade7sections.Grade7Section;

@Repository
public interface IGrade9SectionsRepository extends JpaRepository<Grade9Section, Long> {


    @Query(value = "SELECT * FROM grade_9_sections WHERE name = ?1", nativeQuery = true)
    Grade9Section getSectionByName(String name);
}
