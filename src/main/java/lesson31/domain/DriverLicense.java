package lesson31.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "driver_licenses")
@Getter
@Setter
//@ToString
public class DriverLicense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Embedded
    private HumanInfo humanInfo;
    @Enumerated(EnumType.STRING)
    private Category category;


    @OneToOne(mappedBy = "driverLicense")
    private Client client;
}
