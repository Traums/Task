package example1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        SqliteJob sqliteJob = new SqliteJob(new SqliteWorkerBuilderImpl().setDbName("users").build());

        sqliteJob.insertHero(new HeroBuilderImpl().setId(1)
                                            .setName("Vova")
                                            .setLevel(1)
                                            .setUltimate("-")
                                            .build());
        sqliteJob.logHeroList(sqliteJob.readTable());
    }
}
