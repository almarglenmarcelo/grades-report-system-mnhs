package system.gradereports.mnhs.forms.quarterlyrating.third_quarter;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public interface IThirdQuarterService {

    ResponseEntity<Object> insertGrade(HashMap<String, Object> data);

    ResponseEntity<Object> updateGrade(HashMap<String, Object> data);

}
