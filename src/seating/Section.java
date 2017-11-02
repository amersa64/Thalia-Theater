package seating;

import java.util.Arrays;

import utility.SeatIDGenerator;
import utility.SectionIDGenerator;

public class Section {
	String sid;
	String section_name;
	Row[] Rows;
	double price;
	
	
	public Section(String Name, int rows, int seats){
		this.section_name = Name;
		this.sid = String.valueOf(SectionIDGenerator.getInstance().getNext());
		this.Rows = new Row[rows];
		SeatIDGenerator.getInstance().reset();
		for (int i =0;i<rows;i++){
			this.Rows[i] = new Row(seats, i,this);
		}
	}

	public String getName() {
		return section_name;
	}
	public void setName(String name) {
		this.section_name = name;
	}
	public Row[] getRows() {
		return Rows;
	}
	public void setRows(Row[] rows) {
		Rows = rows;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double sectionFee) {
		this.price = sectionFee;
	}
	
	public Seat[] reqNewSeats(int numSeats, int startRow, int startSeat){
		int initSeat = -1;
		Seat[] seats;
		int rowCounter;
		for (rowCounter = startRow; rowCounter < this.Rows.length; rowCounter++){
			initSeat = this.Rows[rowCounter].getAvailSeats(numSeats, startSeat);
			if (initSeat != -1){
				break;
			}
		}
		if (initSeat == -1){
			seats = null;
		}
		else {
			seats = new Seat[numSeats];
			for (int t = 0; t < numSeats; t ++){
				seats[t] = this.Rows[rowCounter].getSeats()[t+initSeat];
			}
		}
		return seats;
	}

	@Override
	public String toString() {
		return "Section [Name=" + section_name + ", Rows=" + Arrays.toString(Rows) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((section_name == null) ? 0 : section_name.hashCode());
		result = prime * result + Arrays.hashCode(Rows);
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Section other = (Section) obj;
		if (section_name == null) {
			if (other.section_name != null)
				return false;
		} else if (!section_name.equals(other.section_name))
			return false;
		if (!Arrays.equals(Rows, other.Rows))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}


	
}
