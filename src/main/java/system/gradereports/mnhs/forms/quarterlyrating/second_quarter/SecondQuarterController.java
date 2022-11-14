package system.gradereports.mnhs.forms.quarterlyrating.second_quarter;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/quarters")
public class SecondQuarterController {

    private ISecondQuarterService secondQuarterService;

    @PostMapping("/second")
    public ResponseEntity<Object> insertGrades(@RequestBody HashMap<String, Object> data){
        return secondQuarterService.insertGrade(data);
    }

    @PutMapping("/second")
    public ResponseEntity<Object> updateGrades(@RequestBody HashMap<String, Object> data){
        return secondQuarterService.updateGrade(data);
    }
}
