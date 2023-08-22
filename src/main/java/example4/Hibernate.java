package example4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Hibernate {
    Session session;
    Hibernate(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                                                .configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        this.session = factory.openSession();
    }
    public HeroesMap getRecord(int id){
         return this.session.get(HeroesMap.class,id);
    }
    public void close(){
        this.session.close();
    }
}
