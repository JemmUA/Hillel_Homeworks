package lesson31.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clients")
@Getter
@Setter
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Embedded
    private HumanInfo humanInfo;
    @Column(nullable = false)
    private String email;
    private Long phone;
    private String about;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_license_id", unique = true, nullable = false)
    private DriverLicense driverLicense;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<Car> cars;

    @ManyToMany
    @JoinTable(
            name = "client_language",
            joinColumns = {@JoinColumn(name = "client_id")},
            inverseJoinColumns = {@JoinColumn(name = "language_id")})
    private Set<Language> languages;


}
