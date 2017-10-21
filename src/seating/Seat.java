package seating;

import utility.SeatIDGenerator;

public class Seat {
	int id;
	boolean isTaken;
	
	public Seat(){
		this.id = SeatIDGenerator.getInstance().getNext();
		this.isTaken=false;
	}
	public Seat(int id, boolean isTaken) {
		this.id = id;
		this.isTaken = isTaken;
	}
	
	public boolean isTaken() {
		return isTaken;
	}
	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (isTaken ? 1231 : 1237);
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
		Seat other = (Seat) obj;
		if (id != other.id)
			return false;
		if (isTaken != other.isTaken)
			return false;
		return true;
	}
	
}
