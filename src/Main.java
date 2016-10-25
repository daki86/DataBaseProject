import java.util.Scanner;

import CRUD.CRUD;
import hibernate.entity.Car;

public class Main {
	
	private static CRUD crud = new CRUD();
	
	public static void main(String[] args) {
	
		int option = 0;
		
		Scanner sc = new Scanner(System.in);
		
		do{
			System.out.println("\n1. Car");
			System.out.println("2. Customer");
			System.out.println("3. Booking list");
			System.out.println("4. quit");
			System.out.print("\nOption: ");
			option = sc.nextInt();
			
			switch(option){
				case 1:
					do{
						System.out.println("\n\tCar");
						crudMenu();
						option = sc.nextInt();
							switch(option){
								case 1:
									crud.createNewRow("Car");
									break;
								case 2:
									crud.updateRow("Car");
									break;
								case 3:
									break;
								case 4:
									break;
							}
					}while(option !=5);
					break;
				case 2:
					do{
						System.out.println("\n\tCustomer");
						crudMenu();
						option = sc.nextInt();
						switch(option){
						
						}
					}while(option !=5);
					break;
				case 3:
					do{
						System.out.println("\n\tBooking");
						crudMenu();
						option = sc.nextInt();
						switch(option){
						
						}
					}while(option !=5);
					break;
			}
		}while(option != 4);
		System.out.println("\nHave a nice trip!");
	}
	
	public static void crudMenu(){
		System.out.println("\t	1. Add");
		System.out.println("\t	2. Update");
		System.out.println("\t	3. Remove");
		System.out.println("\t	3. Search");
		System.out.println("\t	4. Show all");
		System.out.println("\t	5. Back");
		System.out.print("\n\t	Option: ");
	}
}