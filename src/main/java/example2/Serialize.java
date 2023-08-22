package example2;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Serialize {
    void write(String filename, Pudge pud){
//        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./serialDB/" + filename + ".data")))
//        {
//            oos.writeObject(pud);
//            oos.flush();
//        }
//        catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
        try(FileWriter writer = new FileWriter("./serialDB/" + filename + ".txt",true);){
            String data = String.join(" ", String.valueOf(pud.getId()),pud.getName(),String.valueOf(pud.getLevel()),pud.getUltimate());
            data += "\n";
            writer.write(data);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    List<Pudge> read(String filename){
        List<Pudge> pudgeCol = new ArrayList<>();
//        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./serialDB/" + filename + ".data")))
//        {
//            Pudge pudTemp = (Pudge) ois.readObject();
//            pudgeCol.add(pudTemp);
//        }
//        catch(Exception ex){
//
//            System.out.println(ex.getMessage());
//        }
        try(BufferedReader reader = new BufferedReader(new FileReader("./serialDB/" + filename + ".txt"));){
            String lineRecord = reader.readLine();
            while (lineRecord != null){
                Pudge pud = new Pudge();
                String[] parts = lineRecord.split(" ");
                pud.setId(Long.parseLong(parts[0]));
                pud.setName(parts[1]);
                pud.setLevel(Integer.parseInt(parts[2]));
                pud.setUltimate(parts[3]);
                pudgeCol.add(pud);
                lineRecord = reader.readLine();
            }
        }
        catch ( IOException e) {
            throw new RuntimeException(e);
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
