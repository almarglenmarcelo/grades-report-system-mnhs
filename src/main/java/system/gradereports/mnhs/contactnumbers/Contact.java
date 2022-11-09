package system.gradereports.mnhs.contactnumbers;

import lombok.*;
import system.gradereports.mnhs.guardians.Guardian;

import javax.persistence.*;
import java.security.Guard;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name="contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String number;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="guardian_id")
    private Guardian guardian;

    public Contact(Guardian guardian, String number) {
        this.guardian = guardian;
        this.number = number;
    }
}
