package system.gradereports.mnhs.forms.form1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IForm1Repository extends JpaRepository<Form1, Long> {
}
