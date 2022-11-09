package system.gradereports.mnhs.grade8sections;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
@AllArgsConstructor
@Transactional
public class Grade8SectionServiceImpl implements IGrade8SectionService {


    private IGrade8SectionsRepository grade8SectionsRepository;

    @Override
    public ResponseEntity<Object> addSection(HashMap<String, Object> data) {
        HashMap<String, Object> response = new HashMap<>();

        String sectionName = data.get("name").toString();

        Grade8Section grade7Section = new Grade8Section(sectionName);
        grade8SectionsRepository.save(grade7Section);

        response.put("result","grade8_section_added");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> getAllSections() {
        return new ResponseEntity<>(grade8SectionsRepository.findAll(), HttpStatus.OK);
    }
}
