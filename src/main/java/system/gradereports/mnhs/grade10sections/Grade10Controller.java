package system.gradereports.mnhs.grade10sections;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/grade10")
public class Grade10Controller {

    private IGrade10SectionService grade10SectionService;

    @PostMapping
    public ResponseEntity<Object> addSection(@RequestBody HashMap<String, Object> data){
        return grade10SectionService.addSection(data);
    }

    @GetMapping
    public ResponseEntity<Object> getAllSections(){
        return grade10SectionService.getAllSections();
    }


}
