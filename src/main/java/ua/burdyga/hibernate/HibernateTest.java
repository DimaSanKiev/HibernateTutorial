package ua.burdyga.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.burdyga.dto.UserDetails;

import java.util.Date;

public class HibernateTest {

    public static void main(String[] args) {
        // adding user to database
        UserDetails user = new UserDetails();
        user.setUserId(1);
        user.setUserName("First User");
        user.setAddress("First User's address");
        user.setJoinedDate(new Date());
        user.setDescription("Description one");

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        // retrieving user from database
        user = null;
        session = factory.openSession();
        session.beginTransaction();
        user = session.get(UserDetails.class, 1);
        System.out.println("User retrieved: " + user.getUserName());
    }

}
