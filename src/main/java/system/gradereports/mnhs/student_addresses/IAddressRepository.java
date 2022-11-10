package system.gradereports.mnhs.student_addresses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {

    @Query(value = "SELECT * FROM addresses WHERE student_id = ?1", nativeQuery = true)
    Address findAddressByStudentId(Long studentId);

}
