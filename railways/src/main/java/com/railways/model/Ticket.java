package com.railways.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@Table(name="Ticket")
public class Ticket {
	@Id
	@GeneratedValue
	private int id;
	private String fname;
	private String lname;
	private String gender;
	private String doj;
	private Integer age;
	private String trainName;
	private String destination;
	private String source;
	private Integer tickets;
	private float amount;
	private String status;
	private String pnrNo;

	public Ticket() {
		super();
	}

	public Ticket(String fname, String lname, String gender, String doj, Integer age, String trainName,
			String destination, Integer tickets, String source, float amount, String status, String pnrNo) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.doj = doj;
		this.age = age;
		this.trainName = trainName;
		this.destination = destination;
		this.source = source;
		this.amount = amount;
		this.tickets = tickets;
		this.status = status;
		this.pnrNo = pnrNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getTickets() {
		return tickets;
	}

	public void setTickets(Integer tickets) {
		this.tickets = tickets;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(String pnrNo) {
		this.pnrNo = pnrNo;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender + ", doj=" + doj
				+ ", age=" + age + ", trainName=" + trainName + ", destination=" + destination + ", source=" + source
				+ ", tickets=" + tickets + ", amount=" + amount + ", status=" + status + ", pnrNo=" + pnrNo + "]";
	}

}
