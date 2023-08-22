package example4;
import example1.Hero;

import java.sql.SQLException;
import java.util.List;

public class Job {
    MySqlWorker worker;
    Job()  {
        connect();
    }

    private void connect() {
        try {
            this.worker = new MySqlWorker("xxi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void Run(){
        Hero hero = new Hero(1,"hero",1,"*");
//        insertRecord(hero);
        readRecords();
    }
    private void insertRecord(Hero hero){
        try{
            this.worker.insert("heroes",hero);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    private void readRecords(){
        try {
            List<Hero> list = this.worker.getAll();
            for (Hero hero : list){
                String data = String.join(" ",String.valueOf(hero.getId()),hero.getName(),String.valueOf(hero.getLevel()),hero.getUltimate());
                System.out.println(data);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
