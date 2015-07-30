package ua.burdyga.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.burdyga.dto.Address;
import ua.burdyga.dto.UserDetails;

public class HibernateTest {

    public static void main(String[] args) {
        // adding user to database
        UserDetails user = new UserDetails();
        user.setUserName("First User");
        Address addr = new Address();
        addr.setStreet("Street Name");
        addr.setCity("City Name");
        addr.setState("State Name");
        addr.setZipCode("Zip");
        user.setAddress(addr);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        // retrieving user from database
//        user = null;
//        session = factory.openSession();
//        session.beginTransaction();
//        user = session.get(UserDetails.class, 1);
//        System.out.println("User retrieved: " + user.getUserName());
    }

}
