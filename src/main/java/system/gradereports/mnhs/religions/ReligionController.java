package system.gradereports.mnhs.religions;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api/v1/religions")
@AllArgsConstructor
public class ReligionController {

    private IReligionService religionService;

    @PostMapping
    public ResponseEntity<Object> addReligion(@RequestBody HashMap<String, Object> data){
        return religionService.addReligion(data);
    }

    @GetMapping
    public ResponseEntity<Object> getAllReligions(){
        return religionService.getAllReligion();
    }


}
