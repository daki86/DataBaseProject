package rentalCars.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Car;

public class queryCar {

	public static void main(String[] args) {
		
		//Create session factory 
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Car.class)
								.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try{			
			//start a transaction
			session.beginTransaction();
			
			//query car
			List<Car> theCar = session.createQuery("from Car").list();
			
			//display the car
			displayCars(theCar);
			
			//query cars: leased"
			theCar = session.createQuery("from Car s where s.regNr like '%A%'").list();
			
			// display all leased cars
			System.out.println("RegNumber with A");
			displayCars(theCar);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		}finally{
			factory.close();
		}
	}

	private static void displayCars(List<Car> theCar) {
		for(Car car: theCar){
			System.out.println(car);
		}
	}
}
