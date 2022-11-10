package system.gradereports.mnhs.religions;

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
@Entity
@Table(name="religions")
public class Religion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "religion")
    @JsonIgnore
    private List<Student> students;

    public Religion(String name) {
        this.name = name.trim().toUpperCase();
    }

    public void addStudent(Student theStudent){
        if(students == null) {
            students = new ArrayList<>();
        }
        students.add(theStudent);
    }
}
