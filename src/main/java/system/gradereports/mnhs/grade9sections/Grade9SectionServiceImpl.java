package system.gradereports.mnhs.grade9sections;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
@AllArgsConstructor
@Transactional
public class Grade9SectionServiceImpl implements IGrade9SectionService {


    private IGrade9SectionsRepository grade9SectionsRepository;

    @Override
    public ResponseEntity<Object> addSection(HashMap<String, Object> data) {
        HashMap<String, Object> response = new HashMap<>();
        String sectionName = data.get("name").toString();

        Grade9Section grade7Section = new Grade9Section(sectionName);
        grade9SectionsRepository.save(grade7Section);

        response.put("result","grade9_section_added");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> getAllSections() {
        return new ResponseEntity<>(grade9SectionsRepository.findAll(), HttpStatus.OK);
    }
}
