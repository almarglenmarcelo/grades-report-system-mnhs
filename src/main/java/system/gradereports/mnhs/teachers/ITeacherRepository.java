package system.gradereports.mnhs.teachers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Long> {

    @Query(value = "SELECT * FROM teachers WHERE id = ?1", nativeQuery = true)
    Teacher getTeacherById(Long teacherId);

}
