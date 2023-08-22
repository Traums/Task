package example4;

import example1.Hero;
import lombok.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class MySqlWorker {
    private String url = null;
    private Statement stmt;
    private final String user = "admin";
    private final String password = "12345";

    MySqlWorker(String schema) throws SQLException {
        this.url = "jdbc:mysql://localhost:3306/" + schema;
        Connection  con = DriverManager.getConnection(this.url,this.user,this.password);
        this.stmt = con.createStatement();
    }
    public List<Hero> getAll() throws SQLException {
        List<Hero> list = new ArrayList<>();
        ResultSet rs = this.stmt.executeQuery("select * FROM heroes;");
        while (rs.next()){
            Hero hero = new Hero();
            formHero(hero, rs);
            list.add(hero);
            rs.next();
        }
        return list;
    }

    private static void formHero(Hero hero, ResultSet rs) throws SQLException {
        hero.setId(rs.getInt("id"));
        hero.setName(rs.getString("name"));
        hero.setLevel(rs.getInt("level"));
        hero.setUltimate(rs.getString("ultimate"));
    }

    void insert(String dbName,Hero hero){
        try{
            String query = "INSERT INTO " + dbName+ " (id,name,level,ultimate) VALUES ("
                    +  hero.getId() + ",\'"
                    +  hero.getName() + "\',"
                    +  hero.getLevel() + ",\'"
                    +  hero.getUltimate() + "\')";
            this.stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
