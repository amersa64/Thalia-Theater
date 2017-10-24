package edu.iit.cs445.thalia;
import java.time.LocalDate;
import java.util.ArrayList;

import seating.Section;
public class Thalia {
	ArrayList<Show> shows;
	ArrayList<Order> orders;
	ArrayList<Ticket> tickets;
	ArrayList<Donatee> donatees;
	ArrayList<Customer> customers;

	public Show searchShowId(String wid){
		for(Show s: shows){
			if(s.getId().equals(wid))
				return s;
		}
		return null;
	}
	public Section[] viewShowSections(String wid){
		Show show = searchShowId(wid);
		return show.getTheatre().getSections();
	}
	public void deleteShowId(String wid){
		Show show = searchShowId(wid);
		delete(show);
	}
	public ArrayList<Order> viewOrdersByDate(LocalDate startDate, LocalDate endDate){
		ArrayList<Order> orders = new ArrayList<Order>();
		for(Order o: this.orders){
			if(o.getDate().isAfter(startDate) &&  o.getDate().isBefore(endDate)){
				orders.add(o);
			}
		}
		if(orders.isEmpty())
			return null;
		else
			return orders;
	}
	
	
	
	
	//basic functionality 
	public Thalia(ArrayList<Show> shows, ArrayList<Order> orders, ArrayList<Ticket> tickets,
			ArrayList<Donatee> donatees, ArrayList<Customer> customers) {
		this.shows = shows;
		this.orders = orders;
		this.tickets = tickets;
		this.donatees = donatees;
		this.customers = customers;
	}
	public Thalia(){
		this.shows = new ArrayList<Show>();
		this.orders = new ArrayList<Order>();
		this.tickets = new ArrayList<Ticket>();
		this.donatees = new ArrayList<Donatee>();
		this.customers = new ArrayList<Customer>();
	}
	public void add(Show show){
		this.shows.add(show);
	}
	public void add(Ticket ticket){
		this.tickets.add(ticket);
	}
	public void add(Order order){
		this.orders.add(order);
	}
	public void add(Donatee donatee){
		this.donatees.add(donatee);
	}
	public void add(Customer customer){
		this.customers.add(customer);
	}
	
	public void delete(Show show){
		this.shows.remove(show);
	}
	public void delete(Ticket ticket){
		this.tickets.remove(ticket);
	}
	public void delete(Order order){
		this.orders.remove(order);
	}
	public void delete(Donatee donatee){
		this.donatees.remove(donatee);
	}
	public void delete(Customer customer){
		this.customers.remove(customer);
	}
	
	public ArrayList<Show> getShows() {
		return shows;
	}
	public void setShows(ArrayList<Show> shows) {
		this.shows = shows;
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}
	public ArrayList<Donatee> getDonatees() {
		return donatees;
	}
	public void setDonatees(ArrayList<Donatee> donatees) {
		this.donatees = donatees;
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((donatees == null) ? 0 : donatees.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result + ((shows == null) ? 0 : shows.hashCode());
		result = prime * result + ((tickets == null) ? 0 : tickets.hashCode());
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
		Thalia other = (Thalia) obj;
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;
		if (donatees == null) {
			if (other.donatees != null)
				return false;
		} else if (!donatees.equals(other.donatees))
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (shows == null) {
			if (other.shows != null)
				return false;
		} else if (!shows.equals(other.shows))
			return false;
		if (tickets == null) {
			if (other.tickets != null)
				return false;
		} else if (!tickets.equals(other.tickets))
			return false;
		return true;
	}
	
	

}
