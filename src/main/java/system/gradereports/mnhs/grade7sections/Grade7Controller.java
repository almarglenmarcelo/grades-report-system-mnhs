package system.gradereports.mnhs.grade7sections;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/grade7")
public class Grade7Controller {

    private IGrade7SectionService grade7SectionService;

    @PostMapping
    public ResponseEntity<Object> addSection(@RequestBody HashMap<String, Object> data){
        return grade7SectionService.addSection(data);
    }

    @GetMapping
    public ResponseEntity<Object> getAllSections(){
        return grade7SectionService.getAllSections();
    }


}
