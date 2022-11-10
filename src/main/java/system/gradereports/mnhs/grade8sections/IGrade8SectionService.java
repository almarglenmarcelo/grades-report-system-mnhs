package system.gradereports.mnhs.grade8sections;

import org.springframework.http.ResponseEntity;
import system.gradereports.mnhs.grade7sections.Grade7Section;

import java.util.HashMap;
import java.util.Optional;

public interface IGrade8SectionService {

    ResponseEntity<Object> addSection(HashMap<String, Object> data);
    ResponseEntity<Object> getAllSections();

    Optional<Grade8Section> findSectionById(Long sectionId);

    ResponseEntity<Object> addOtherSection(Grade8Section newGrade8Section);

    Grade7Section getSectionByName(String name);

}
