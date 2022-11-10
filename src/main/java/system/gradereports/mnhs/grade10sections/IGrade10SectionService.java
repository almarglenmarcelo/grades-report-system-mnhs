package system.gradereports.mnhs.grade10sections;

import org.springframework.http.ResponseEntity;
import system.gradereports.mnhs.grade7sections.Grade7Section;

import java.util.HashMap;
import java.util.Optional;

public interface IGrade10SectionService {

    ResponseEntity<Object> addSection(HashMap<String, Object> data);
    ResponseEntity<Object> getAllSections();

    Optional<Grade10Section> findSectionById(Long sectionId);

    ResponseEntity<Object> addOtherSection(Grade10Section newGrade10Section);

    Grade10Section getSectionByName(String name);

}
