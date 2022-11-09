package system.gradereports.mnhs.grade7sections;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class Grade7SectionServiceImpl implements IGrade7SectionService{


    private IGrade7SectionsRepository grade7SectionsRepository;

    @Override
    public ResponseEntity<Object> addSection(HashMap<String, Object> data) {
        HashMap<String, Object> response = new HashMap<>();
        String sectionName = data.get("name").toString().toUpperCase();


        Grade7Section grade7Section = new Grade7Section(sectionName);
        grade7SectionsRepository.save(grade7Section);

        response.put("result","grade7_section_added");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> addOtherSection(Grade7Section newGrade7Section) {
        grade7SectionsRepository.save(newGrade7Section);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Override
    public Grade7Section getSectionByName(String name) {
        return grade7SectionsRepository.getSectionByName(name.toUpperCase());
    }

    @Override
    public Optional<Grade7Section> findSectionById(Long sectionId) {

        Optional<Grade7Section> grade7Section = grade7SectionsRepository.findById(sectionId);

        if(grade7Section.isEmpty()){
            return null;
        }

        return grade7Section;
    }
    @Override
    public ResponseEntity<Object> getAllSections() {
        return new ResponseEntity<>(grade7SectionsRepository.findAll(), HttpStatus.OK);
    }
}
