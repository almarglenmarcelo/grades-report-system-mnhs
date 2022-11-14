package system.gradereports.mnhs.forms.quarterlyrating.fourth_quarter;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public interface IFourthQuarterService {

    ResponseEntity<Object> insertGrade(HashMap<String, Object> data);

    ResponseEntity<Object> updateGrade(HashMap<String, Object> data);

}
