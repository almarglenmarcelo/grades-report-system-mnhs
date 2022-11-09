package system.gradereports.mnhs.grade10sections;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public interface IGrade10SectionService {

    ResponseEntity<Object> addSection(HashMap<String, Object> data);
    ResponseEntity<Object> getAllSections();

}
