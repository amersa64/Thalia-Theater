package seating;

import java.util.Arrays;

import seating.Seat.SeatStatus;

public class Row {
	Seat[] Seats;
	int rowId;
	public Row(int seats, int id, Section section){
		this.Seats = new Seat[seats];
		for(int i=0; i<seats;i++){
			this.Seats[i]= new Seat(section.getName());
		}
		this.rowId= id;
	}
	public Seat[] getSeats() {
		return Seats;
	}
	public void setSeats(Seat[] seats) {
		Seats = seats;
	}
	public int getRowId() {
		return rowId;
	}
	public void setRowId(int rowId) {
		this.rowId = rowId;
	}
	
	public int getAvailSeats(int numSeats, int start){
		//This counter will check how many seats are contiguously available
		int counter = 0;
		
		for (int s = start; s < numSeats; s++){
			if (this.Seats[s].status.equals(SeatStatus.available)){
				counter = 0;
			}
			else {
				counter ++;
			}
			if (counter == numSeats){
//				System.out.println("We found a match!");
				return s;
				//Prompt the user if they want to use these seats, if not, then we need to check the next available set of seats
			}
		}
		return -1;
	}
	
	
	
	@Override
	public String toString() {
		return "Row [Seats=" + Arrays.toString(Seats) + ", rowId=" + rowId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(Seats);
		result = prime * result + rowId;
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
		Row other = (Row) obj;
		if (!Arrays.equals(Seats, other.Seats))
			return false;
		if (rowId != other.rowId)
			return false;
		return true;
	}
	

}
