package system.gradereports.mnhs.ethnicgroups;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/ethnicGroups")
public class EthnicGroupController {

    private IEthnicGroupService ethnicGroupService;

    @PostMapping
    public ResponseEntity<Object> addEthnicGroup(@RequestBody HashMap<String, Object> data) {
        return ethnicGroupService.addEthnicGroup(data);
    }

    @GetMapping
    public ResponseEntity<Object> getEthnicGroups() {
        return ethnicGroupService.getAllEthnicGroup();
    }


}
