package system.gradereports.mnhs.religions;

import org.springframework.http.ResponseEntity;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Optional;

public interface IReligionService {

    ResponseEntity<Object> addReligion(HashMap<String, Object> data);

    ResponseEntity<Object> addOtherReligion(Religion religion);
    Optional<Religion> findReligionById(Long religionId);
    ResponseEntity<Object> getAllReligion();

    Religion getLatestRecord();

    Religion findReligionByName(String name);





}
