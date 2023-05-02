package lesson37.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Human implements Cloneable {
    private String name;
    private String sex;
    private int age;
    private Parrot parrot;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
