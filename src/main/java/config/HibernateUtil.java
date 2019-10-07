package config;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    private static final SessionFactory sessionFactory = configuration.buildSessionFactory();
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

