package ua.burdyga.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.burdyga.dto.Address;
import ua.burdyga.dto.UserDetails;
import ua.burdyga.dto.Vehicle;

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
        Address officeAddr = new Address();
        officeAddr.setStreet("Office Street Name");
        officeAddr.setCity("Office City Name");
        officeAddr.setState("Office State Name");
        officeAddr.setZipCode("Office Zip");
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");
        user.setVehicle(vehicle);

        user.getAddressList().add(homeAddr);
        user.getAddressList().add(officeAddr);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(vehicle);
        session.getTransaction().commit();
        session.close();

        user = null;
        session = factory.openSession();
        user = session.get(UserDetails.class, 1);
        session.close();
        System.out.println(user.getAddressList().size());


    }

}
