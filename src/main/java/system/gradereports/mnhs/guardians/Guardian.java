package system.gradereports.mnhs.guardians;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import system.gradereports.mnhs.contactnumbers.Contact;
import system.gradereports.mnhs.students.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="guardians")
public class Guardian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName = null;
    private String lastName;
    private String relationship;
    
    @OneToMany(mappedBy = "guardian")
    @JsonIgnore
    private List<Student> students;
    @OneToMany(mappedBy = "guardian", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Contact> contactNumbers;


    public Guardian(Long id, String firstName, String middleName, String lastName, String relationshi) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.relationship = relationship;
        this.students = students;
    }

    public Guardian(String firstName, String middleName, String lastName, String relationship) {
        this.firstName = firstName.trim().toUpperCase();
        this.middleName = middleName.trim().toUpperCase();
        this.lastName = lastName.trim().toUpperCase();
        this.relationship = relationship.trim().toUpperCase();
    }

    public void addStudent(Student student){
        if(students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }
    public void addContactNumber(Contact contact){
        if(contactNumbers == null) {
            contactNumbers = new ArrayList<>();
        }

        contactNumbers.add(contact);
    }
}
