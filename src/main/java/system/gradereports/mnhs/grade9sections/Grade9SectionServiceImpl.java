package system.gradereports.mnhs.grade9sections;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import system.gradereports.mnhs.grade7sections.Grade7Section;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class Grade9SectionServiceImpl implements IGrade9SectionService {

    private IGrade9SectionsRepository grade9SectionsRepository;

    @Override
    public ResponseEntity<Object> addSection(HashMap<String, Object> data) {
        HashMap<String, Object> response = new HashMap<>();
        String sectionName = data.get("name").toString().toUpperCase();
        Grade9Section grade9Section = new Grade9Section(sectionName);

        Grade9Section priorGrade9Section = grade9SectionsRepository.getSectionByName(sectionName);

        if(priorGrade9Section != null) {
            response.put("result","grade9_section_already_exists");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        grade9SectionsRepository.save(grade9Section);
        response.put("result","grade9_section_added");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> addOtherSection(Grade9Section newGrade9Section) {
        grade9SectionsRepository.save(newGrade9Section);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Override
    public Grade9Section getSectionByName(String name) {
        return grade9SectionsRepository.getSectionByName(name.toUpperCase());
    }

    @Override
    public Optional<Grade9Section> findSectionById(Long sectionId) {

        Optional<Grade9Section> grade9Section = grade9SectionsRepository.findById(sectionId);

        if(grade9Section.isEmpty()){
            return null;
        }

        return grade9Section;
    }
    @Override
    public ResponseEntity<Object> getAllSections() {
        return new ResponseEntity<>(grade9SectionsRepository.findAll(), HttpStatus.OK);
    }
}
