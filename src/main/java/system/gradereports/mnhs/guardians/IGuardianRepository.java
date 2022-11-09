package system.gradereports.mnhs.guardians;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGuardianRepository extends JpaRepository<Guardian, Long> {
}
