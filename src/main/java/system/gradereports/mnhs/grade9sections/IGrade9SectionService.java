package system.gradereports.mnhs.grade9sections;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public interface IGrade9SectionService {

    ResponseEntity<Object> addSection(HashMap<String, Object> data);
    ResponseEntity<Object> getAllSections();

}
