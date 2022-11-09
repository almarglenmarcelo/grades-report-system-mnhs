package system.gradereports.mnhs.grade8sections;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import system.gradereports.mnhs.students.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="grade_8_sections")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Grade8Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    private String name;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "grade8Section")
    @JsonIgnore
    private List<Student> students;
    public Grade8Section(String name) {
        this.name = name.toUpperCase();
    }


    public void addStudent(Student student){
        if(students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }
}
