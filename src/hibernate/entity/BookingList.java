package hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booking_list")
public class BookingList {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="social_security_number")
	private int ssn;
	
	@Column(name="registration_number")
	private String regNr;
	
	@Column(name="start_date")
	private Date startDate;
	
	public BookingList(int ssn, String regNr, Date startDate, Date endDate, int totDays, int totCost) {
		this.ssn = ssn;
		this.regNr = regNr;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totDays = totDays;
		this.totCost = totCost;
	}

	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="total_days")
	private int totDays;
	
	@Column(name="total_cost")
	private int totCost;
	
	public BookingList(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getRegNr() {
		return regNr;
	}

	public void setRegNr(String regNr) {
		this.regNr = regNr;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getTotDays() {
		return totDays;
	}

	public void setTotDays(int totDays) {
		this.totDays = totDays;
	}

	public int getTotCost() {
		return totCost;
	}

	public void setTotCost(int totCost) {
		this.totCost = totCost;
	}

	@Override
	public String toString() {
		return "BookingList [id=" + id + ", ssn=" + ssn + ", regNr=" + regNr + ", startDate=" + startDate + ", endDate="
				+ endDate + ", totDays=" + totDays + ", totCost=" + totCost + "]";
	}
	
}
