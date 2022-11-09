package system.gradereports.mnhs.grade9sections;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/grade9")
public class Grade9Controller {

    private IGrade9SectionService grade9SectionsService;

    @PostMapping
    public ResponseEntity<Object> addSection(@RequestBody HashMap<String, Object> data){
        return grade9SectionsService.addSection(data);
    }

    @GetMapping
    public ResponseEntity<Object> getAllSections(){
        return grade9SectionsService.getAllSections();
    }


}
