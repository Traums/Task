package example2;

import java.util.List;

public class Job {
    public Serialize serial;
    Job(){
        this.serial = new Serialize();
    }
    void run(){
        Pudge pudge = new Pudge(1,"Pudge",1,"&");

        serializeRecord("DB",pudge);
        this.serial.output(readAll("DB"));
    }
    void serializeRecord(String filename,Pudge pud){
        this.serial.write(filename, pud);
    }
    List<Pudge> readAll(String filename){
        return this.serial.read(filename);
    }
}
