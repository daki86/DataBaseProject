package CRUD;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Car;

public class CRUD {
	
	private Scanner sc = new Scanner(System.in);
	
	//Create session factory 
	private SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Car.class)
								.buildSessionFactory();
	
	public void createNewRow(String table){
		
		//Create session
		Session session = factory.getCurrentSession();
		
		if(table.equalsIgnoreCase("car")){
			try{
				String regNr;
				String brand;
				String model;
				int price;
				
				System.out.print("\nBrand: ");
				brand = sc.nextLine().toUpperCase();
				System.out.print("Model: ");
				model = sc.nextLine().toUpperCase();
				System.out.print("Registration number: ");
				regNr = sc.nextLine().toUpperCase();
				System.out.print("Price/day: ");
				price = sc.nextInt();
				
				//use the session object to save Java object
				Car tempCar = new Car(regNr, brand, model, price);			
				
				//start a transaction
				session.beginTransaction();
				
				//save the car object
				System.out.println("Car added...");
				session.save(tempCar);
				
				//commit transaction
				session.getTransaction().commit();
			}finally{
				factory.close();
			}	
		}
	}
	
	public void updateRow(String table){
		//Create session
		Session session = factory.getCurrentSession();
				
		try{				
			String reg;
			
			//get a new session and start transaction
			session.beginTransaction();	
			List<Car> theCar = session.createQuery("from Car").list();
			
			//display the car
			displayCars(theCar);
			
			System.out.print("Registration number: ");
			reg = sc.nextLine();
			
			// retrive student based on the id: primary key
			System.out.println("\nGetting car with regNr:" + reg);
			
			Car myCar = session.get(Car.class, reg);
			
			System.out.println("Updating car brand....");
			myCar.setPrice(244);
			
			//commit the transaction
			session.getTransaction().commit();
			
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
