package system.gradereports.mnhs.grade8sections;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/grade8")
public class Grade8Controller {

    private IGrade8SectionService grade8SectionService;

    @PostMapping
    public ResponseEntity<Object> addSection(@RequestBody HashMap<String, Object> data){
        return grade8SectionService.addSection(data);
    }

    @GetMapping
    public ResponseEntity<Object> getAllSections(){
        return grade8SectionService.getAllSections();
    }


}
