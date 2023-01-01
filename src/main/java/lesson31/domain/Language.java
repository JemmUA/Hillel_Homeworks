package lesson31.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "languages")
@Getter
@Setter
@ToString
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageWorld language;

    @ManyToMany(mappedBy = "languages")
    private Set<Client> clients;
}






