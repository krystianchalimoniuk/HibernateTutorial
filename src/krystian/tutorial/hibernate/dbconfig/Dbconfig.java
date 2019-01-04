package krystian.tutorial.hibernate.dbconfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Dbconfig {
private static Configuration configuration;
private static SessionFactory factory;
private static Session session;
private Dbconfig() {}
public static Session getInstance() {
	configuration=new Configuration().configure();
	factory=configuration.buildSessionFactory();
	session=factory.openSession();
	return session;
}

}
