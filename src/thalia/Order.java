package thalia;

import java.time.LocalDate;
import java.util.Arrays;

import utility.OrderIDGenerator;

public class Order {
	String id;
	LocalDate date;
	Patron patron;
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
	public Patron getCustomer() {
		return patron;
	}
	public void setCustomer(Patron patron) {
		this.patron = patron;
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
	public Order(String id, LocalDate date, Patron patron, Ticket[] tickets, double bill) {
		super();
		this.id = id;
		this.date = date;
		this.patron = patron;
		this.tickets = tickets;
		this.bill = bill;
	}
	public Order(Patron patron,Ticket[] tickets){
		this.id= String.valueOf(OrderIDGenerator.getInstance().getNext());
		this.date = LocalDate.now();
		this.patron = patron;
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
		result = prime * result + ((patron == null) ? 0 : patron.hashCode());
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
		if (patron == null) {
			if (other.patron != null)
				return false;
		} else if (!patron.equals(other.patron))
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
