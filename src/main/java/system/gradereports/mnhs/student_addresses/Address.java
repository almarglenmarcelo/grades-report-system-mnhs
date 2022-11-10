package system.gradereports.mnhs.student_addresses;

import lombok.*;
import system.gradereports.mnhs.forms.form1.Form1;
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

    // Form1 Entity
    @OneToOne(mappedBy = "address")
    private Form1 form1;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "student_id")
    private Student student;

    public Address(String houseNumber, String street, String barangay, String cityMunicipality, String province, Student student) {
        this.houseNumber = houseNumber;
        this.street = street.trim().toUpperCase();
        this.barangay = barangay.trim().toUpperCase();
        this.cityMunicipality = cityMunicipality.trim().toUpperCase();
        this.province = province.trim().toUpperCase();
        this.student = student;
    }

    public String getFullAddress() {
//        831 A. De Castro St. Malinta, Valenzuela City
        return String.format("%s %s. %s, $s %s", houseNumber, street, barangay, cityMunicipality, province);
    }
}
