package system.gradereports.mnhs.departments;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import system.gradereports.mnhs.teachers.Teacher;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "department", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Teacher> teachers;

    public Department(String name) {
        this.name = name.trim().toUpperCase();
    }

    public void addTeachers(Teacher teacher){
        if(teachers == null)
            teachers = new ArrayList<>();

        teachers.add(teacher);
    }
}
