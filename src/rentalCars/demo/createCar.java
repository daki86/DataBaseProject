package rentalCars.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Car;

public class createCar {

	public static void main(String[] args) {
		
		//Create session factory 
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Car.class)
								.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try{
			//use the session object to save Java object
			System.out.println("Creating a new car object...");
			Car tempCar = new Car("445AFD","BMW","X5",345);			
			
			//start a transaction
			session.beginTransaction();
			
			//save the car object
			System.out.println("Saving the car...");
			session.save(tempCar);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		}finally{
			factory.close();
		}
	}
}
