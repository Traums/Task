package example2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.example.Hero;

@Data
@AllArgsConstructor
public class Pudge extends Hero {
    Pudge(long id,String name,int level, String ultimate){
        super( id, name,level, ultimate );
    }

}
