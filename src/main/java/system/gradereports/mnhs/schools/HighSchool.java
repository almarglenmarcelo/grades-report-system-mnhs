package system.gradereports.mnhs.schools;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="highschool_institutions")
public class HighSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String schoolId;

    private Integer district;

    private String division;

    private String region;

    public HighSchool(String name, String schoolId, Integer district, String division, String region) {
        this.name = name;
        this.schoolId = schoolId;
        this.district = district;
        this.division = division;
        this.region = region;
    }
}
