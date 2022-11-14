package system.gradereports.mnhs.forms.quarterlyrating.second_quarter;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public interface ISecondQuarterService {

    ResponseEntity<Object> insertGrade(HashMap<String, Object> data);

    ResponseEntity<Object> updateGrade(HashMap<String, Object> data);


}
