
package adapters;

//import java.time.LocalDateTime;

import thalia.Order;
import thalia.ShowData;
import thalia.Ticket;

public class OrderLookAdapter {
	String oid;
	String wid;
	ShowData show_info;
	String date_ordered;
	double order_amount;
	PatronAdapter patron_info;
	int number_of_tickets;
	TicketOrderAdapter[] tickets;
	public OrderLookAdapter(Order order){
		this.oid=order.getOid();
		this.wid= order.getShow().getWid();
		this.show_info=order.getShow().getShow_info();
		int iyear = order.getDate_ordered().getYear();
		int imonth = order.getDate_ordered().getMonthValue();
		int iday = order.getDate_ordered().getDayOfMonth();
		int ihour = order.getDate_ordered().getHour();
		int iminute = order.getDate_ordered().getMinute();
		String year = String.valueOf(iyear);
		String month = String.valueOf(imonth);
		String day = String.valueOf(iday);
		String hour = String.valueOf(ihour);
		String minute = String.valueOf(iminute);
		this.date_ordered = (year + "-" + month + "-" + day + " " + hour + ":" + minute);
//		this.date_ordered=order.getDate_ordered();
		this.order_amount=order.getOrder_amount();
		this.patron_info= new PatronAdapter(order.getPatron_info());
		this.number_of_tickets = order.getNumber_of_tickets();
		this.tickets = new TicketOrderAdapter[order.getTickets().length];
		for (int i = 0; i < order.getTickets().length; i++){
			Ticket ticket = order.getTickets()[i];
			System.out.print(ticket.toString());
			this.tickets[i] = new TicketOrderAdapter(ticket);
		}
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public ShowData getShow_info() {
		return show_info;
	}
	public void setShow_info(ShowData show_info) {
		this.show_info = show_info;
	}
	public String getDate_ordered() {
		return date_ordered;
	}
	public void setDate_ordered(String date_ordered) {
		this.date_ordered = date_ordered;
	}
	public double getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(double order_amount) {
		this.order_amount = order_amount;
	}
	public PatronAdapter getPatron_info() {
		return patron_info;
	}
	public void setPatron_info(PatronAdapter patron_info) {
		this.patron_info = patron_info;
	}
	public int getNumber_of_tickets() {
		return number_of_tickets;
	}
	public void setNumber_of_tickets(int number_of_tickets) {
		this.number_of_tickets = number_of_tickets;
	}
	public TicketOrderAdapter[] getTickets() {
		return tickets;
	}
	public void setTickets(TicketOrderAdapter[] tickets) {
		this.tickets = tickets;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_ordered == null) ? 0 : date_ordered.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		long temp;
		temp = Double.doubleToLongBits(order_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((patron_info == null) ? 0 : patron_info.hashCode());
		result = prime * result + ((show_info == null) ? 0 : show_info.hashCode());
		result = prime * result + ((wid == null) ? 0 : wid.hashCode());
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
		OrderLookAdapter other = (OrderLookAdapter) obj;
		if (date_ordered == null) {
			if (other.date_ordered != null)
				return false;
		} else if (!date_ordered.equals(other.date_ordered))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (Double.doubleToLongBits(order_amount) != Double.doubleToLongBits(other.order_amount))
			return false;
		if (patron_info == null) {
			if (other.patron_info != null)
				return false;
		} else if (!patron_info.equals(other.patron_info))
			return false;
		if (show_info == null) {
			if (other.show_info != null)
				return false;
		} else if (!show_info.equals(other.show_info))
			return false;
		if (wid == null) {
			if (other.wid != null)
				return false;
		} else if (!wid.equals(other.wid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderAdapter [oid=" + oid + ", wid=" + wid + ", show_info=" + show_info + ", date_ordered="
				+ date_ordered + ", order_amount=" + order_amount + ", patron_info=" + patron_info + "]";
	}
	
	

}
