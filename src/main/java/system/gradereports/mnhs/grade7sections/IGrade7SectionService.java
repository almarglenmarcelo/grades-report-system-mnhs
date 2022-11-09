package system.gradereports.mnhs.grade7sections;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Optional;

public interface IGrade7SectionService {

    ResponseEntity<Object> addSection(HashMap<String, Object> data);
    ResponseEntity<Object> getAllSections();
    Optional<Grade7Section> findSectionById(Long sectionId);

    ResponseEntity<Object> addOtherSection(Grade7Section newGrade7Section);

    Grade7Section getSectionByName(String name);
}
