package system.gradereports.mnhs.students;


import lombok.*;
import system.gradereports.mnhs.MnhsUserRoles;
import system.gradereports.mnhs.ethnicgroups.EthnicGroup;
import system.gradereports.mnhs.forms.form1.Form1;
import system.gradereports.mnhs.grade10sections.Grade10Section;
import system.gradereports.mnhs.grade7sections.Grade7Section;
import system.gradereports.mnhs.grade8sections.Grade8Section;
import system.gradereports.mnhs.guardians.Guardian;
import system.gradereports.mnhs.parents.Parent;
import system.gradereports.mnhs.religions.Religion;
import system.gradereports.mnhs.student_addresses.Address;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lrn;
    private String firstName;
    private String middleName = null;
    private String lastName;
    private String nameExtension = null;
    private Boolean isMale;
    private LocalDate birthdate;
    private Integer ageAsOfFirstFridayJune;
    private String motherTongue;
    private String role;

    // Form1 Entity
    @OneToOne(mappedBy = "student")
    private Form1 form1;


    // Address Entity
    @OneToOne(mappedBy = "student")
    private Address address;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "guardian_id")
    private Guardian guardian = null;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "ethnic_group_id")
    private EthnicGroup ethnicGroup = null;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "religion_id")
    private Religion religion = null;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "grade7_section")
    private Grade7Section grade7Section = null;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "grade8_section")
    private Grade8Section grade8Section = null;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "grade9_section")
    private system.gradereports.mnhs.grade9sections.Grade9Section grade9Section = null;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "grade10_section")
    private Grade10Section grade10Section = null;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name="parent_students",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name="parent_id"))
    private List<Parent> parents;

    //   As Grade 7 Student
    public Student(String lrn, String firstName, String middleName, String lastName, String nameExtension, Boolean isMale, String birthdate, Integer ageAsOfFirstFridayJune, String motherTongue, EthnicGroup ethnicGroup, Religion religion, Grade7Section grade7Section) {
        this.lrn = lrn;
        this.firstName = firstName.trim().toUpperCase();
        this.middleName = (middleName.isEmpty())? null: middleName.trim().toUpperCase();
        this.lastName = lastName.trim().toUpperCase();
        this.nameExtension = (nameExtension.isEmpty())? null: nameExtension.trim().toUpperCase();
        this.isMale = isMale;
        this.birthdate = LocalDate.parse(birthdate);
        this.ageAsOfFirstFridayJune = ageAsOfFirstFridayJune;
        this.motherTongue = motherTongue.trim().toUpperCase();
        this.ethnicGroup = ethnicGroup;
        this.religion = religion;
        this.role = MnhsUserRoles.STUDENT.toString();
        this.grade7Section = grade7Section;
    }

    //    As Grade 8 Student
    public Student(String lrn, String firstName, String middleName, String lastName, String nameExtension, Boolean isMale, String birthdate, Integer ageAsOfFirstFridayJune, String motherTongue, EthnicGroup ethnicGroup, Religion religion, Grade7Section grade7Section, Grade8Section grade8Section) {
        this.lrn = lrn;
        this.firstName = firstName.trim().toUpperCase();
        this.middleName = (middleName.isEmpty())? null: middleName.trim().toUpperCase();
        this.lastName = lastName.trim().toUpperCase();;
        this.nameExtension = (nameExtension.isEmpty())? null: nameExtension.trim().toUpperCase();
        this.isMale = isMale;
        this.birthdate = LocalDate.parse(birthdate);
        this.ageAsOfFirstFridayJune = ageAsOfFirstFridayJune;
        this.motherTongue = motherTongue.trim().toUpperCase();
        this.ethnicGroup = ethnicGroup;
        this.religion = religion;
        this.role = MnhsUserRoles.STUDENT.toString();
        this.grade7Section = grade7Section;
        this.grade8Section = grade8Section;
    }

    //    As Grade 9 Student
    public Student(String lrn, String firstName, String middleName, String lastName, String nameExtension, Boolean isMale, String birthdate, Integer ageAsOfFirstFridayJune, String motherTongue, EthnicGroup ethnicGroup, Religion religion, Grade7Section grade7Section, Grade8Section grade8Section, system.gradereports.mnhs.grade9sections.Grade9Section grade9Section) {
        this.lrn = lrn;
        this.firstName = firstName.trim().toUpperCase();
        this.middleName = (middleName.isEmpty())? null: middleName.trim().toUpperCase();
        this.lastName = lastName.trim().toUpperCase();
        this.nameExtension = (nameExtension.isEmpty())? null: nameExtension.trim().toUpperCase();
        this.isMale = isMale;
        this.birthdate = LocalDate.parse(birthdate);;
        this.ageAsOfFirstFridayJune = ageAsOfFirstFridayJune;
        this.motherTongue = motherTongue.trim().toUpperCase();
        this.ethnicGroup = ethnicGroup;
        this.religion = religion;
        this.role = MnhsUserRoles.STUDENT.toString();
        this.grade7Section = grade7Section;
        this.grade8Section = grade8Section;
        this.grade9Section = grade9Section;
    }

    //  As Grade 10 Student
    public Student(String lrn, String firstName, String middleName, String lastName, String nameExtension, Boolean isMale, LocalDate birthdate, Integer ageAsOfFirstFridayJune, String motherTongue, EthnicGroup ethnicGroup, Religion religion, Grade7Section grade7Section, Grade8Section grade8Section, system.gradereports.mnhs.grade9sections.Grade9Section grade9Section, Grade10Section grade10Section) {
        this.lrn = lrn;
        this.firstName = firstName.trim().toUpperCase();
        this.middleName = (middleName.isEmpty())? null: middleName.trim().toUpperCase();
        this.lastName = lastName.toUpperCase();
        this.nameExtension = (nameExtension.isEmpty())? null: nameExtension.trim().toUpperCase();
        this.isMale = isMale;
        this.birthdate = birthdate;
        this.ageAsOfFirstFridayJune = ageAsOfFirstFridayJune;
        this.motherTongue = motherTongue.trim().toUpperCase();
        this.ethnicGroup = ethnicGroup;
        this.religion = religion;
        this.role = MnhsUserRoles.STUDENT.toString();
        this.grade7Section = grade7Section;
        this.grade8Section = grade8Section;
        this.grade9Section = grade9Section;
        this.grade10Section = grade10Section;
    }

    public void addReligion(Religion theReligion){
        religion = theReligion;
    }

    public void addParents(Parent theParent){
        if(parents == null){
            parents = new ArrayList<>();
        }

        parents.add(theParent);
    }
}
