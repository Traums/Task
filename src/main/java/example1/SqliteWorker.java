package example1;

import lombok.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Data
public class SqliteWorker {
        Connection connection = null;
        String url;
        Statement statement;
        String dbName;
        String query;

//    SqliteWorker(String dbName) throws SQLException {
//        this.dbName = dbName;
//        this.url = "jdbc:sqlite:sqlite/" + dbName + ".db";
//        this.connection = DriverManager.getConnection(url);
//        this.stat = this.connection.createStatement();
//    }
    void insertHero( Hero hero) throws SQLException {
        query = "INSERT INTO " + this.dbName+ " (id,name,level,ultimate) VALUES ("
                +  hero.getId() + ",\'"
                +  hero.getName() + "\',"
                +  hero.getLevel() + ",\'"
                +  hero.getUltimate() + "\')";
        statement.executeUpdate(query);
    }
    List<Hero> readHeroes() throws SQLException {
        List<Hero> listHero = new ArrayList<>();
        this.query = "select * from " + this.dbName;
        ResultSet rs = statement.executeQuery(this.query);
        while (rs.next()){
            listHero.add(mapToHero(rs));
        }
        return listHero;
    }

    private Hero mapToHero(ResultSet rs) throws SQLException {
        Hero hero = new Hero();
        hero.setId(rs.getInt("id"));
        hero.setName(rs.getString("name"));
        hero.setLevel(rs.getInt("level"));
        hero.setUltimate(rs.getString("ultimate"));
        return hero;
    }
}
