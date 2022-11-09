package system.gradereports.mnhs.student_addresses;

import lombok.*;
import system.gradereports.mnhs.students.Student;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String houseNumber;

    private String street;

    private String barangay;

    private String cityMunicipality;

    private String province;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "student_id")
    private Student student;

    public Address(String houseNumber, String street, String barangay, String cityMunicipality, String province, Student student) {
        this.houseNumber = houseNumber;
        this.street = street.toUpperCase();
        this.barangay = barangay.toUpperCase();
        this.cityMunicipality = cityMunicipality.toUpperCase();
        this.province = province.toUpperCase();
        this.student = student;
    }

    public String getFullAddress() {
//        831 A. De Castro St. Malinta, Valenzuela City
        return String.format("%s %s. %s, $s %s", houseNumber, street, barangay, cityMunicipality, province);
    }
}
