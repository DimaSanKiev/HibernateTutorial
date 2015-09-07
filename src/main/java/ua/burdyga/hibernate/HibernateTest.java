package ua.burdyga.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.burdyga.dto.*;

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

        // implementing inheritance
        TwoWheeler bike = new TwoWheeler();
        bike.setVehicleName("Bike");
        bike.setSteeringHandle("Bike Steering Handle");
        FourWheeler car = new FourWheeler();
        car.setVehicleName("Porsche");
        car.setSteeringWheel("Porsche Steering Wheel");

        Laptop laptop = new Laptop();
        Laptop laptop2 = new Laptop();
        laptop.setLaptopName("MacBookPro");
        laptop2.setLaptopName("HP Envy");
        user.getLaptops().add(laptop);
        user.getLaptops().add(laptop2);
        laptop.setUser(user);
        laptop2.setUser(user);

        Device device = new Device();
        device.setDeviceName("SmartPhone");
        Device device2 = new Device();
        device2.setDeviceName("Tablet");
        user.getDevices().add(device);
        user.getDevices().add(device2);
//        device.setUser(user);
//        device2.setUser(user);

        user.getAddressList().add(homeAddr);
        user.getAddressList().add(officeAddr);


        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.save(vehicle);
        session.save(bike);
        session.save(car);
        session.save(laptop);
        session.save(laptop2);
        // CRUD operations
//        for (int i = 0; i < 10; i++) {
//            UserDetails user1 = new UserDetails();
//            user1.setUserName("User " + i);
//            session.save(user1);
//        }
        UserDetails user1 = (UserDetails) session.get(UserDetails.class, 1);
        user1.setUserName("Updated User");
        session.update(user1);
        session.getTransaction().commit();
        session.close();

        user = null;
        session = factory.openSession();
        user = session.get(UserDetails.class, 1);
        session.close();

        System.out.println("User name pulled up is: " + user1.getUserName());
        System.out.println(user.getAddressList().size());

    }

}
