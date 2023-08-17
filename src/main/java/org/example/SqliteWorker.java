package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;


public class SqliteWorker {
        Connection con = null;
        String url;
        Statement stat;
        String dbName;
        String query;

    SqliteWorker(String dbName) throws SQLException {
        this.dbName = dbName;
        con = null;
        url = "jdbc:sqlite:sqlite/" + dbName + ".db";
        con = DriverManager.getConnection(url);
        stat = con.createStatement();
    }
    void insert(String dbName,Hero hero){
        try{
            query = "INSERT INTO " + dbName+ " (id,name,level,ultimate) VALUES ("
                    +  hero.getId() + ",\'"
                    +  hero.getName() + "\',"
                    +  hero.getLevel() + ",\'"
                    +  hero.getUltimate() + "\')";
            stat.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    List<Hero> readAll(){
        List<Hero> listHero= new ArrayList<>();
        try {
            query = "select * from " + dbName;
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()){
                Hero hero = new Hero();
                hero.setId(rs.getInt("id"));
                hero.setName(rs.getString("name"));
                hero.setLevel(rs.getInt("level"));
                hero.setUltimate(rs.getString("ultimate"));

                listHero.add(hero);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listHero;
    }
    void output(List<Hero> heroCol){
        for(int i = 0;i<heroCol.size();i++){
            System.out.println(heroCol.get(i).getName());
        }
    }

}
