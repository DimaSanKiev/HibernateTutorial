package ua.burdyga.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.burdyga.dto.UserDetails;

public class HibernateTest {

    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        user.setUserId(2);
        user.setUserName("SecondUser");

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

}
