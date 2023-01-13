package lesson34.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Phone {

    private Integer id;
    private String type;
    private Long number;

    public Phone(Integer id, String type, Long number) {
        this.id = id;
        this.type = type;
        this.number = number;
    }
}
