package system.gradereports.mnhs.ethnicgroups;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import system.gradereports.mnhs.students.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ethnic_groups")
public class EthnicGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    private String name;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "ethnicGroup")
    @JsonIgnore
    private List<Student> students;
    public EthnicGroup(String name) {
        this.name = name.trim().toUpperCase();
    }

    public void addStudent(Student theStudent){
        if(students == null) {
            students = new ArrayList<>();
        }
        students.add(theStudent);
    }
}
