package system.gradereports.mnhs.religions;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ReligionServiceImpl implements IReligionService{

    private IReligionRepository religionRepository;

    @Override
    public ResponseEntity<Object> addReligion(HashMap<String, Object> data) {
        HashMap<String, Object> response = new HashMap<>();

        String religionName = data.get("name").toString();

        Religion religion = new Religion(religionName);

        religionRepository.save(religion);
        response.put("result", "religion_added");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> addOtherReligion(Religion religion) {

        religionRepository.save(religion);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @Override
    public Religion getLatestRecord() {
        return religionRepository.getLatestRecord();
    }
    @Override
    public Optional<Religion> findReligionById(Long religionId) {

        Optional<Religion> theReligion = religionRepository.findById(religionId);

        if(theReligion.isEmpty()){
            return null;
        }

        return theReligion;
    }
    @Override
    public Religion findReligionByName(String name) {
        return religionRepository.findReligionByName(name);
    }

    @Override
    public ResponseEntity<Object> getAllReligion() {
        return new ResponseEntity<>(religionRepository.findAll(), HttpStatus.OK);
    }
}
