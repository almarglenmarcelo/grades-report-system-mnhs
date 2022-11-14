package system.gradereports.mnhs.forms.quarterlyrating.first_quarter;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public interface IFirstQuarterService {

    ResponseEntity<Object> insertGrade(HashMap<String, Object> data);

    ResponseEntity<Object> updateGrade(HashMap<String, Object> data);


}
