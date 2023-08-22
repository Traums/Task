package example1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hero {
    protected long id;
    protected String Name;
    protected int level;
    protected String Ultimate;
}
