package system.gradereports.mnhs.grade8sections;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public interface IGrade8SectionService {

    ResponseEntity<Object> addSection(HashMap<String, Object> data);
    ResponseEntity<Object> getAllSections();

}
