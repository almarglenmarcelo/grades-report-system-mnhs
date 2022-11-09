package system.gradereports.mnhs.ethnicgroups;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEthnicGroupRepository extends JpaRepository<EthnicGroup, Long> {

    @Query(value = "SELECT * FROM ethnic_groups WHERE name = ?1", nativeQuery = true)
    EthnicGroup findEthnicGroupByName(String name);

    @Query(value = "SELECT * FROM ethnic_groups ORDER BY id DESC LIMIT 1", nativeQuery = true)
    EthnicGroup getLatestRecord();
}
