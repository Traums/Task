package example4;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "heroes")
public class HeroesMap {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "level")
    private int level;
    @Column(name = "ultimate")
    private String ultimate;
}
