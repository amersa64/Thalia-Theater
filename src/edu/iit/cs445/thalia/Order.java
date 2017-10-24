package edu.iit.cs445.thalia;

import java.time.LocalDate;
import java.util.Arrays;

import utility.OrderIDGenerator;

public class Order {
	String id;
	LocalDate date;
	Customer customer;
	Ticket[] tickets;
	double bill;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Ticket[] getTickets() {
		return tickets;
	}
	public void setTickets(Ticket[] tickets) {
		this.tickets = tickets;
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	public Order(String id, LocalDate date, Customer customer, Ticket[] tickets, double bill) {
		super();
		this.id = id;
		this.date = date;
		this.customer = customer;
		this.tickets = tickets;
		this.bill = bill;
	}
	public Order(Customer customer,Ticket[] tickets){
		this.id= String.valueOf(OrderIDGenerator.getInstance().getNext());
		this.date = LocalDate.now();
		this.customer = customer;
		this.bill=0;
		for(Ticket t: tickets){
			this.bill+=t.getPrice();
		}
	}
	public void scanTicket(Ticket t){
		for(Ticket mytic: tickets){
			if(mytic.equals(t)){
				mytic.setScanned(true);
			}
		}
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(bill);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(tickets);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Double.doubleToLongBits(bill) != Double.doubleToLongBits(other.bill))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(tickets, other.tickets))
			return false;
		return true;
	}
	
	

}
