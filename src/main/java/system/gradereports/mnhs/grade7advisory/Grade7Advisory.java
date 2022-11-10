package system.gradereports.mnhs.grade7advisory;

import lombok.*;
import system.gradereports.mnhs.grade7sections.Grade7Section;
import system.gradereports.mnhs.teachers.Teacher;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name="grade7_advisory")
public class Grade7Advisory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long teacherId;
    private Long grade7SectionId;
    private String schoolYear;

    public Grade7Advisory(Long teacherId, Long grade7SectionId, String schoolYear) {
        this.teacherId = teacherId;
        this.grade7SectionId = grade7SectionId;
        this.schoolYear = schoolYear.trim().toUpperCase();
    }
    public Grade7Advisory(Teacher teacher, Grade7Section grade7Section, String schoolYear) {
        Long teacherId = teacher.getId();
        Long grade7SectionId = grade7Section.getId();

        this.teacherId = teacherId;
        this.grade7SectionId = grade7SectionId;
        this.schoolYear = schoolYear.trim().toUpperCase();
    }
}
