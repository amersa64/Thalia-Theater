package seating;

import java.util.Arrays;

public class Row {
	Seat[] Seats;
	int rowId;
	public Row(int seats, int id){
		this.Seats = new Seat[seats];
		for(int i=0; i<seats;i++){
			this.Seats[i]= new Seat();
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
	@Override
	public String toString() {
		return "Row [Seats=" + Arrays.toString(Seats) + ", rowId=" + rowId + "]";
	}
	

}
