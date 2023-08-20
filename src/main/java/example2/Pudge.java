package example2;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Hero;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class Pudge extends Hero implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    public Pudge(int id, String name , int level, String ultimate, String cat) {
        super(id,name,level,ultimate);
    }
}
