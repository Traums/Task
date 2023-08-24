package example1;

public class JobBuilderImpl implements JobBuilder{
    SqliteJob sqliteJob;
    @Override
    public JobBuilder setWorker(SqliteWorker worker) {
        return null;
    }

    @Override
    public SqliteJob Build() {
        return sqliteJob;
    }

}
