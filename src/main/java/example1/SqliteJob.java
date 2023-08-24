package example1;

import lombok.Data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Data
public class SqliteJob {
    SqliteWorker worker;
    SqliteJob(SqliteWorker worker){
        this.worker = worker;
    }
    public void insertHero(Hero hero) {
        try{
            worker.insertHero(hero);
        } catch (SQLException e) {
            System.out.println("Ошибка вставки записи в БД: " + e.getMessage());
        }
    }
    public List<Hero> readTable(){
        List<Hero> list = new ArrayList<>();
        try{
            list = this.worker.readHeroes();
        } catch (SQLException e) {
            System.out.println("Ошибка чтения записей из БД: " + e.getMessage());;
        }
        return list;
    }
    public void logHeroList(List<Hero> heroList){
        for (Hero hero : heroList) {
            System.out.println(hero.getId() + " "
                    + hero.getName() + " "
                    + hero.getLevel() + " "
                    + hero.getUltimate());
        }
    }
}
