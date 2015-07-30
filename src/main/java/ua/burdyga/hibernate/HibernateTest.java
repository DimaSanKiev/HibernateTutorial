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
        Address homeAddr = new Address();
        homeAddr.setStreet("Home Street Name");
        homeAddr.setCity("Home City Name");
        homeAddr.setState("Home State Name");
        homeAddr.setZipCode("Home Zip");
        user.setHomeAddress(homeAddr);
        Address officeAddr = new Address();
        officeAddr.setStreet("Office Street Name");
        officeAddr.setCity("Office City Name");
        officeAddr.setState("Office State Name");
        officeAddr.setZipCode("Office Zip");
        user.setOfficeAddress(officeAddr);


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
