package thalia;

public class Donatee {
	String id;
	Ticket ticket;
	boolean hasTicket;
	public Donatee(String id, Ticket ticket, boolean hasTicket) {
		super();
		this.id = id;
		this.ticket = ticket;
		this.hasTicket = hasTicket;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public boolean isHasTicket() {
		return hasTicket;
	}
	public void setHasTicket(boolean hasTicket) {
		this.hasTicket = hasTicket;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (hasTicket ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ticket == null) ? 0 : ticket.hashCode());
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
		Donatee other = (Donatee) obj;
		if (hasTicket != other.hasTicket)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ticket == null) {
			if (other.ticket != null)
				return false;
		} else if (!ticket.equals(other.ticket))
			return false;
		return true;
	}
	

}
