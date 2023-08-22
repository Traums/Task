package example4;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
//        Job job = new Job();
//        job.Run();

        JobHibernate jobHiber = new JobHibernate();
        jobHiber.Run();
    }
}
