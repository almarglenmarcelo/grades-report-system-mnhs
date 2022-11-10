package system.gradereports.mnhs.grade9sections;

import org.springframework.http.ResponseEntity;
import system.gradereports.mnhs.grade7sections.Grade7Section;

import java.util.HashMap;
import java.util.Optional;

public interface IGrade9SectionService {

    ResponseEntity<Object> addSection(HashMap<String, Object> data);
    ResponseEntity<Object> getAllSections();

    Optional<Grade9Section> findSectionById(Long sectionId);

    ResponseEntity<Object> addOtherSection(Grade9Section newGrade9Section);

    Grade9Section getSectionByName(String name);

}
