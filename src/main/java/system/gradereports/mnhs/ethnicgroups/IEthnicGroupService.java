package system.gradereports.mnhs.ethnicgroups;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Optional;

public interface IEthnicGroupService {

    ResponseEntity<Object> addEthnicGroup(HashMap<String, Object> data);

    ResponseEntity<Object> addOtherEthnicGroup(EthnicGroup ethnicGroup);

    ResponseEntity<Object> getAllEthnicGroup();

    EthnicGroup getLatestRecord();
    Optional<EthnicGroup> findEthnicGroupById(Long ethnicGroupId);

    EthnicGroup findEthnicGroupByName(String name);

}
