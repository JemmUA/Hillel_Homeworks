package lesson28.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Client {
    private int id;
    private String name;
    private int age;
    private String email;
    private long phone;
    private String about;

}
