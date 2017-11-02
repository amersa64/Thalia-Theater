package seating;

import utility.SeatIDGenerator;

public class Seat {
	public enum SeatStatus{
		available,sold
	}
	String cid;
	SeatStatus status;
	
	public Seat(String sectionName){
		this.cid = sectionName + SeatIDGenerator.getInstance().getNext();
		this.status=SeatStatus.available;
	}
	public Seat(String id, SeatStatus isTaken) {
		this.cid = id;
		this.status = isTaken;
	}
	
	public SeatStatus getStatus() {
		return status;
	}
	public void setStatus(SeatStatus isTaken) {
		this.status = isTaken;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String id) {
		this.cid = id;
	}

	@Override
	public String toString() {
		return "Seat [cid=" + cid + ", status=" + status + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + (status.hashCode());
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
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
}
