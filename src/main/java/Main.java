import org.flo99rida.Actor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Timestamp;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Actor actor2 = new Actor();
        actor2.setActorId(992);
        actor2.setFirstName("Ahmed");
        actor2.setLastName("Deabs");
        actor2.setLastUpdateTs(new Timestamp(new Date().getTime()));

        System.out.println(actor2.toString());

        Configuration cfg = new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Actor.class);

        try (ServiceRegistry serviceRegistry =
                     new StandardServiceRegistryBuilder()
                             .applySettings(cfg.getProperties())
                             .build()) {

            SessionFactory sf = cfg.buildSessionFactory(serviceRegistry);
            Session session = sf.openSession();

            session.beginTransaction();        // ---------> Start Transaction
            Actor actor3 = session.get(Actor.class, 992);
//                session.persist(actor2);
            session.getTransaction().commit(); // ------------> Commit Transaction

            System.out.println(actor3.toString());

        }

    }
}
