package system.gradereports.mnhs.forms.quarterlyrating.first_quarter;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/quarters")
public class FirstQuarterController {

    private IFirstQuarterService firstQuarterService;

    @PostMapping("/first")
    public ResponseEntity<Object> insertGrades(@RequestBody HashMap<String, Object> data){
        return firstQuarterService.insertGrade(data);
    }

    @PutMapping("/first")
    public ResponseEntity<Object> updateGrades(@RequestBody HashMap<String, Object> data){
        return firstQuarterService.updateGrade(data);
    }
}
