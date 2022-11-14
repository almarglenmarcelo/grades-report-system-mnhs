package system.gradereports.mnhs.subjects;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import system.gradereports.mnhs.forms.quarterlyrating.first_quarter.FirstQuarter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
@Table(name="subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //One-To-Many Relations
    @OneToMany(mappedBy = "subject")
    @JsonIgnore
    private List<FirstQuarter> firstQuarter;
    public Subject(String name) {
        this.name = name.trim().toUpperCase();
    }



}
