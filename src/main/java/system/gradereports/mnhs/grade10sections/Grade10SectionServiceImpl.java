package system.gradereports.mnhs.grade10sections;

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
public class Grade10SectionServiceImpl implements IGrade10SectionService {


    private IGrade10SectionsRepository grade10SectionsRepository;

    @Override
    public ResponseEntity<Object> addSection(HashMap<String, Object> data) {
        HashMap<String, Object> response = new HashMap<>();
        String sectionName = data.get("name").toString().toUpperCase();
        Grade10Section grade10Section = new Grade10Section(sectionName);

        Grade10Section priorGrade10Section = grade10SectionsRepository.getSectionByName(sectionName);

        if(priorGrade10Section != null) {
            response.put("result","grade10_section_already_exists");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        grade10SectionsRepository.save(grade10Section);
        response.put("result","grade10_section_added");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> addOtherSection(Grade10Section newGrade10Section) {
        grade10SectionsRepository.save(newGrade10Section);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Override
    public Grade10Section getSectionByName(String name) {
        return grade10SectionsRepository.getSectionByName(name.toUpperCase());
    }

    @Override
    public Optional<Grade10Section> findSectionById(Long sectionId) {

        Optional<Grade10Section> grade10Section = grade10SectionsRepository.findById(sectionId);

        if(grade10Section.isEmpty()){
            return null;
        }

        return grade10Section;
    }
    @Override
    public ResponseEntity<Object> getAllSections() {
        return new ResponseEntity<>(grade10SectionsRepository.findAll(), HttpStatus.OK);
    }
}
