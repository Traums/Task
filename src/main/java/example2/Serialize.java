package example2;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Serialize {
    private int a = 4;
    void write(String filename, Pudge pud){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./serialDB/" + filename + ".dat")))
        {
            oos.writeObject(pud);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
    List<Pudge> read(String filename){
        List<Pudge> pudgeCol = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./serialDB/" + filename + ".dat")))
        {
            pudgeCol = (List<Pudge>)ois.readObject();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return pudgeCol;
    }
    void output(List<Pudge> pudgeCol){
        for (Pudge pudge : pudgeCol) {
            System.out.println(pudge.getId() + " " +
                    pudge.getName() + " " +
                    pudge.getLevel() + " " +
                    pudge.getUltimate());
        }
    }
}
