package lesson29.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table (name = "clients")
@Getter
@Setter
@ToString
@NamedNativeQueries({
        @NamedNativeQuery( name = "getAll", query = "select * from Clients", resultClass = Client.class),
        @NamedNativeQuery( name = "getByName", query = "select * from Clients WHERE name = :name", resultClass = Client.class),
        @NamedNativeQuery( name = "getByPhone", query = "select * from Clients WHERE phone = :phone", resultClass = Client.class),
        @NamedNativeQuery( name = "getByAge", query = "select * from Clients WHERE age = :age", resultClass = Client.class)
})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private Long phone;
    private String about;
}
