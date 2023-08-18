package example2;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Hero;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Pudge extends Hero implements Serializable {

    public Pudge(int id, String name , int level, String ultimate) {
        super.setId(id);
        super.setName(name);
        super.setLevel(level);
        super.setUltimate(ultimate);
    }
}
