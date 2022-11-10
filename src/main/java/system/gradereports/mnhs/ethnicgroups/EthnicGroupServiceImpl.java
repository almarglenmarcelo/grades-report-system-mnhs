package system.gradereports.mnhs.ethnicgroups;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class EthnicGroupServiceImpl implements  IEthnicGroupService{

    private IEthnicGroupRepository ethnicGroupRepository;

    @Override
    public ResponseEntity<Object> addEthnicGroup(HashMap<String, Object> data) {
        HashMap<String, Object> response = new HashMap<>();
        String ethnicGroupName = data.get("name").toString();
        EthnicGroup ethnicGroup = new EthnicGroup(ethnicGroupName);

        EthnicGroup priorEthnicGroup = ethnicGroupRepository.findEthnicGroupByName(ethnicGroupName);

        if(priorEthnicGroup != null) {
            response.put("result", "ethnic_group_already_exists");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        ethnicGroupRepository.save(ethnicGroup);
        response.put("result", "ethnic_group_added");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public EthnicGroup getLatestRecord() {
        return ethnicGroupRepository.getLatestRecord();
    }

    @Override
    public Optional<EthnicGroup> findEthnicGroupById(Long ethnicGroupId) {
        Optional<EthnicGroup> ethnicGroup = ethnicGroupRepository.findById(ethnicGroupId);

        if(ethnicGroup.isEmpty()){
            return null;
        }

        return ethnicGroup;
    }

    @Override
    public ResponseEntity<Object> addOtherEthnicGroup(EthnicGroup ethnicGroup) {

        ethnicGroupRepository.save(ethnicGroup);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Override
    public EthnicGroup findEthnicGroupByName(String name) {
        EthnicGroup ethnicGroup = ethnicGroupRepository.findEthnicGroupByName(name);

        return ethnicGroup;
    }

    @Override
    public ResponseEntity<Object> getAllEthnicGroup() {
        return new ResponseEntity<>(ethnicGroupRepository.findAll(), HttpStatus.OK);
    }
}
