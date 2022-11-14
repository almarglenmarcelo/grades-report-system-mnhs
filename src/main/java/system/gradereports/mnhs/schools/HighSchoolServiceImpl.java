package system.gradereports.mnhs.schools;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class HighSchoolServiceImpl implements IHighSchoolService{

    private final IHighSchoolRepository highSchoolRepository;
}
