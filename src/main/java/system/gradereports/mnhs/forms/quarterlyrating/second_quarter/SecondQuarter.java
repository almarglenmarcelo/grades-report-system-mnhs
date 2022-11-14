package system.gradereports.mnhs.forms.quarterlyrating.second_quarter;


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
@Table(name = "second_quarter")
public class SecondQuarter {
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

    public SecondQuarter(SecondQuarter firstQuarter, Subject subject, Long grade, Student student) {
        this.id = firstQuarter.getId();
        this.subject = subject;
        this.grade = grade;
        this.student = student;
    }

    public SecondQuarter(Subject subject, Long grade, Student student) {
        this.subject = subject;
        this.grade = grade;
        this.student = student;
    }


}
