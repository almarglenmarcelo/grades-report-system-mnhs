package system.gradereports.mnhs.grade10sections;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
@AllArgsConstructor
@Transactional
public class Grade10SectionServiceImpl implements IGrade10SectionService {


    private IGrade10SectionsRepository grade10SectionsRepository;

    @Override
    public ResponseEntity<Object> addSection(HashMap<String, Object> data) {
        HashMap<String, Object> response = new HashMap<>();
        String sectionName = data.get("name").toString();

        Grade10Section grade7Section = new Grade10Section(sectionName);
        grade10SectionsRepository.save(grade7Section);

        response.put("result","grade10_section_added");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> getAllSections() {
        return new ResponseEntity<>(grade10SectionsRepository.findAll(), HttpStatus.OK);
    }
}
