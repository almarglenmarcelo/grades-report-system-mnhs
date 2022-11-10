package system.gradereports.mnhs.teachers;

import lombok.*;
import system.gradereports.mnhs.MnhsUserRoles;
import system.gradereports.mnhs.departments.Department;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name="teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String role;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
    private Department department;


    public Teacher(String firstName, String middleName, String lastName) {
        this.firstName = firstName.trim().toUpperCase();
        this.middleName = (middleName.isEmpty())? null : middleName.trim().toUpperCase();
        this.lastName = lastName.trim().toUpperCase();
        this.role = MnhsUserRoles.TEACHER.toString();
    }

    public Teacher(String firstName, String middleName, String lastName, Department department) {
        this.firstName = firstName.trim().toUpperCase();
        this.middleName = (middleName.isEmpty())? null : middleName.trim().toUpperCase();
        this.lastName = lastName.trim().toUpperCase();
        this.role = MnhsUserRoles.TEACHER.toString();
        this.department = department;
    }

}
