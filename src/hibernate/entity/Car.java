package hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="car")
public class Car {
	
	@Id
	@Column(name="registration_number")
	private String regNr;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="leased")
	private Boolean leased;
	
	@Column(name="model")
	private String model;
	
	@Column(name="price")
	private int price;

	public Car(){
		
	}

	public Car(String regNr, String brand, String model, int price) {
		this.regNr = regNr;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.leased = false;
	}

	public String getRegNr() {
		return regNr;
	}

	public void setRegNr(String regNr) {
		this.regNr = regNr;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Boolean getLeased() {
		return leased;
	}

	public void setLeased(Boolean leased) {
		this.leased = leased;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Car [regNr=" + regNr + ", brand=" + brand + ", leased=" + leased + ", model=" + model + ", price="
				+ price + "]";
	}
}
