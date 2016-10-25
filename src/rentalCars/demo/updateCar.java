package rentalCars.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Car;

public class updateCar {

	public static void main(String[] args) {
		
		//Create session factory 
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Car.class)
								.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try{			
			String reg = "RCA956";
			
			//get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();			
			
			// retrive student based on the id: primary key
			System.out.println("\nGetting car brand:" + reg);
			
			Car myCar = session.get(Car.class, reg);
			
			System.out.println("Updating car brand....");
			myCar.setPrice(244);
			
			//commit the transaction
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//upadate price for all cars
			System.out.println("Update price for all cars");
			
			session.createQuery("update Car set price=1500").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		}finally{
			factory.close();
		}
	}
}
