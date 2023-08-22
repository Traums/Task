package example4;

public class JobHibernate {
    Hibernate hiber;
    JobHibernate(){
        this.hiber = new Hibernate();
    }
    public void Run(){
        HeroesMap hero = (HeroesMap) this.hiber.getRecord(2);
        System.out.println(hero.getName());
    }
}
