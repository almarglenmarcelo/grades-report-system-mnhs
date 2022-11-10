package system.gradereports.mnhs.grade8sections;

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
public class Grade8SectionServiceImpl implements IGrade8SectionService {


    private IGrade8SectionsRepository grade8SectionsRepository;

    @Override
    public ResponseEntity<Object> addSection(HashMap<String, Object> data) {
        HashMap<String, Object> response = new HashMap<>();
        String sectionName = data.get("name").toString().toUpperCase();
        Grade8Section grade8Section = new Grade8Section(sectionName);

        Grade7Section priorGrade8Section = grade8SectionsRepository.getSectionByName(sectionName);

        if(priorGrade8Section != null) {
            response.put("result","grade8_section_already_exists");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        grade8SectionsRepository.save(grade8Section);
        response.put("result","grade8_section_added");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> addOtherSection(Grade8Section newGrade8Section) {
        grade8SectionsRepository.save(newGrade8Section);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Override
    public Grade7Section getSectionByName(String name) {
        return grade8SectionsRepository.getSectionByName(name.toUpperCase());
    }

    @Override
    public Optional<Grade8Section> findSectionById(Long sectionId) {

        Optional<Grade8Section> grade8Section = grade8SectionsRepository.findById(sectionId);

        if(grade8Section.isEmpty()){
            return null;
        }

        return grade8Section;
    }
    @Override
    public ResponseEntity<Object> getAllSections() {
        return new ResponseEntity<>(grade8SectionsRepository.findAll(), HttpStatus.OK);
    }
}
