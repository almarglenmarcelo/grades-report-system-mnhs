package system.gradereports.mnhs.forms.quarterlyrating.third_quarter;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/quarters")
public class ThirdQuarterController {

    private IThirdQuarterService thirdQuarterService;

    @PostMapping("/third")
    public ResponseEntity<Object> insertGrades(@RequestBody HashMap<String, Object> data){
        return thirdQuarterService.insertGrade(data);
    }

    @PutMapping("/third")
    public ResponseEntity<Object> updateGrades(@RequestBody HashMap<String, Object> data){
        return thirdQuarterService.updateGrade(data);
    }
}
