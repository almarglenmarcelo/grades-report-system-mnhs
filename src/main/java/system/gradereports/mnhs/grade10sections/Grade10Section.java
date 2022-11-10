package system.gradereports.mnhs.grade10sections;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import system.gradereports.mnhs.students.Student;
import system.gradereports.mnhs.teachers.Teacher;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="grade_10_sections")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Grade10Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    private String name;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "grade10Section")
    @JsonIgnore
    private List<Student> students;


    public Grade10Section(String name) {
        this.name = name.trim().toUpperCase();
    }

    public void addStudent(Student student){
        if(students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }

}
