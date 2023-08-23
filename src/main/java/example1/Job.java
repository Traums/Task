package example1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Job {

    void run() {
//        Hero user = new Hero(1,"Vova",1,"-");
        Hero user = new HeroBuilderImpl().setId(1).setName("Vova").setLevel(1).setUltimate("-").build();
        insertRecord("users",user);
        readTable("users");
    }

    private static void insertRecord(String dbName,Hero hero) {
        try {
            SqliteWorker worker = new SqliteWorker(dbName);
            worker.insert(dbName,hero);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void readTable(String dbName) {
        try{
            List<Hero> heroCol = new ArrayList<>();
            SqliteWorker worker = new SqliteWorker(dbName);
            heroCol = worker.readAll();
            worker.output(heroCol);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
