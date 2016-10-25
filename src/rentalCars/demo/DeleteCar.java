package rentalCars.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Car;

public class DeleteCar {

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
			
			//delete the car
//			System.out.println("Deleting car: " + myCar);
//			session.delete(myCar);
			
			//alternative delete 
			//delete car reg = 445AFD
			System.out.println("Delet car with reg 445AFD");
			session.createQuery("delete from Car where regNr=445AFD").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		}finally{
			factory.close();
		}
	}
}
