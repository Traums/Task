package example1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteWorkerBuilderImpl implements SqliteWorkerBuilder{
    SqliteWorker worker = new SqliteWorker();
    @Override
    public SqliteWorkerBuilder setDbName(String dbName) {
        worker.setDbName(dbName);
        return this;
    }

    public SqliteWorker build(){
        try{
            worker.setUrl( "jdbc:sqlite:sqlite/" + worker.getDbName() + ".db");
            worker.setConnection(DriverManager.getConnection(worker.getUrl()));
            worker.setStatement(worker.connection.createStatement());
        } catch (SQLException e) {
            System.out.println("Ошибка создания соединения: " + e.getMessage());;
        }
        return worker;
    }
}
