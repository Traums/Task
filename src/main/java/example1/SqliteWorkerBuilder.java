package example1;

import java.sql.Connection;
import java.sql.Statement;

public interface SqliteWorkerBuilder {
    SqliteWorkerBuilder setDbName(String dbName);
//    SqliteWorkerBuilder setUrl(String url);
//    SqliteWorkerBuilder setConnection(Connection connection);
//    SqliteWorkerBuilder setStatement(Statement statement);
    SqliteWorker build();
}
