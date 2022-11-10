package system.gradereports.mnhs.grade7advisory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGrade7AdvisoryRepository extends JpaRepository<Grade7Advisory, Long> {
}
