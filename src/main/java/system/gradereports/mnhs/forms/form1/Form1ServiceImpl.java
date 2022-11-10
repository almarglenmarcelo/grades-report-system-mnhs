package system.gradereports.mnhs.forms.form1;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
@Transactional
@AllArgsConstructor
public class Form1ServiceImpl implements IForm1Service{

    private final IForm1Repository form1Repository;

    @Override
    public ResponseEntity<Object> insertNewForm1(Form1 form1) {
        HashMap<String, Object> response = new HashMap<>();

        form1Repository.save(form1);
        response.put("result", "form1_created_successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> getAllForm1() {
        return new ResponseEntity<>(form1Repository.findAll(), HttpStatus.OK);
    }
}
