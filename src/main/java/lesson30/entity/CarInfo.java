package lesson30.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "car_infos")
@Getter
@Setter
public class CarInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String colour;
    @Embedded
    private Info info;
}
