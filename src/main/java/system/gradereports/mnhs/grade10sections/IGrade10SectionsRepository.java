package system.gradereports.mnhs.grade10sections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import system.gradereports.mnhs.grade7sections.Grade7Section;

@Repository
public interface IGrade10SectionsRepository extends JpaRepository<Grade10Section, Long> {

    @Query(value = "SELECT * FROM grade_10_sections WHERE name = ?1", nativeQuery = true)
    Grade10Section getSectionByName(String name);
}
