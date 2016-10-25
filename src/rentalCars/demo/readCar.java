package rentalCars.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Car;

public class readCar {

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
			Car tempCar = new Car("RCA956","Volvo","S80",230);			
			
			//start a transaction
			session.beginTransaction();
			
			//save the car object
			System.out.println("Saving the car...");
			System.out.println(tempCar);
			session.save(tempCar);
			
			//commit transaction
			session.getTransaction().commit();
			
			
			//find out "id" primary key
			System.out.println("Saved car " + tempCar.getRegNr());
			
			//get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();			
			
			// retrive student based on the id: primary key
			System.out.println("\nGetting car id(reg number):" + tempCar.getRegNr());
			
			Car myCar = session.get(Car.class, tempCar.getRegNr());
			
			System.out.println("Get complete: " + myCar);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		}finally{
			factory.close();
		}
	}
}
