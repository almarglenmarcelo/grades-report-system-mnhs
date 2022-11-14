package system.gradereports.mnhs.forms.quarterlyrating.first_quarter;


import lombok.*;
import system.gradereports.mnhs.students.Student;
import system.gradereports.mnhs.subjects.Subject;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "first_quarter")
public class FirstQuarter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject subject;
    private Long grade;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public FirstQuarter(FirstQuarter firstQuarter, Subject subject, Long grade, Student student) {
        this.id = firstQuarter.getId();
        this.subject = subject;
        this.grade = grade;
        this.student = student;
    }

    public FirstQuarter(Subject subject, Long grade, Student student) {
        this.subject = subject;
        this.grade = grade;
        this.student = student;
    }


}
