package example3;

import example1.Hero;

import java.io.IOException;

public class Job {
    void run() throws IOException {
        HttpWorker worker = new HttpWorker();
        Hero hero = new Hero(1,"Pudge",1,"");
        worker.sendPOST(hero);
    }
}
