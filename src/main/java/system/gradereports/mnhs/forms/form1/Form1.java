package system.gradereports.mnhs.forms.form1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import system.gradereports.mnhs.ethnicgroups.EthnicGroup;
import system.gradereports.mnhs.guardians.Guardian;
import system.gradereports.mnhs.parents.Parent;
import system.gradereports.mnhs.religions.Religion;
import system.gradereports.mnhs.student_addresses.Address;
import system.gradereports.mnhs.students.Student;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="form1")
public class Form1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private Long fatherId;
    private Long motherId;

    @OneToOne
    @JoinColumn(name = "guardian_id")
    private Guardian guardian;

    private String schoolYear;
    private String remarks;

    public Form1(Student student, Address address, Parent father, Parent mother, Guardian guardian, String schoolYear, String remarks) {
        Long fatherId = father.getId();
        Long motherId = mother.getId();

        this.student = student;
        this.address = address;
        this.fatherId = fatherId;
        this.motherId = motherId;
        this.guardian = guardian;
        this.schoolYear = schoolYear;
        this.remarks = (remarks.isEmpty())? "": remarks.trim().toUpperCase();
    }
}
