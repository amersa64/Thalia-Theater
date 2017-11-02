package thalia;


import seating.*;

public class Ticket {
	String id;
	Seat seat;
	Show show;
	boolean scanned;
	boolean donated;
	
	public Ticket(Seat seat, Show show) {
		this.id= show.getWid()+seat.getCid();
		this.seat = seat;
		this.show = show;
		this.scanned= false;
		this.donated = false;
	}
	public Ticket(String id, Seat seat, Show show, boolean scanned, boolean donated) {
		this.id = id;
		this.seat = seat;
		this.show = show;
		this.scanned = scanned;
		this.donated = donated;
	}
	public double getPrice(){
		double price = 0;
		for(Section section: this.show.getSeating_info()){
			for(int r=0; r<section.getRows().length;r++){
				for(int s=0; s<section.getRows()[r].getSeats().length;s++){
					if(section.getRows()[r].getSeats()[s].equals(this.seat)){
						price = section.getPrice();
						return price;
					}
				}
			}
		}
		return price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public boolean isScanned() {
		return scanned;
	}
	public void setScanned(boolean scanned) {
		this.scanned = scanned;
	}
	public boolean isDonated() {
		return donated;
	}
	public void setDonated(boolean donated) {
		this.donated = donated;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (donated ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (scanned ? 1231 : 1237);
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
		Ticket other = (Ticket) obj;
		if (donated != other.donated)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (scanned != other.scanned)
			return false;
		return true;
	}
	
	

}
