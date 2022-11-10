package system.gradereports.mnhs.parents;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import system.gradereports.mnhs.forms.form1.Form1;
import system.gradereports.mnhs.students.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name="parents")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName = null;
    private String lastName;
    private Boolean isMale;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name="parent_students",
            joinColumns = @JoinColumn(name="parent_id"),
            inverseJoinColumns = @JoinColumn(name="student_id"))
    private List<Student> students;


    public Parent(Long id, String firstName, String middleName, String lastName) {
        this.id = id;
        this.firstName = firstName.trim().toUpperCase();;
        this.middleName = middleName.trim().toUpperCase();;
        this.lastName = lastName.trim().toUpperCase();;
    }

    public Parent(String firstName, String middleName, String lastName, Boolean isMale) {
        this.firstName = firstName.trim().toUpperCase();
        this.middleName = middleName.trim().toUpperCase();
        this.lastName = lastName.trim().toUpperCase();
        this.isMale = isMale;
    }

    public void addChild(Student student){
        if(students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }
}
