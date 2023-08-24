package example1;

public interface JobBuilder {
    JobBuilder setWorker(SqliteWorker worker);
    SqliteJob Build();
}
