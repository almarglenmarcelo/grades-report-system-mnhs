package system.gradereports.mnhs.religions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IReligionRepository extends JpaRepository<Religion, Long> {

    @Query(value = "SELECT * FROM religions WHERE name = ?1", nativeQuery = true)
    Religion findReligionByName(String name);

    @Query(value = "SELECT * FROM religions ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Religion getLatestRecord();


}
