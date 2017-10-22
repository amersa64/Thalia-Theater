package seating;

import java.util.Arrays;

import utility.SeatIDGenerator;

public class Section {
	String Name;
	Row[] Rows;
	static double sideSectionPrice = 2;
	static double regularSectionPrice = 5;
	double sectionFee;
	
	
	public Section(String Name, int rows, int seats){
		this.Name = Name;
		this.Rows = new Row[rows];
		SeatIDGenerator.getInstance().reset();
		for (int i =0;i<rows;i++){
			this.Rows[i] = new Row(seats, i,this);
		}
		if (Name.equals("A") || Name.equals("D")){
			this.sectionFee = sideSectionPrice;
		}
		else {
			this.sectionFee = regularSectionPrice;
		}
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Row[] getRows() {
		return Rows;
	}
	public void setRows(Row[] rows) {
		Rows = rows;
	}
	
	public double getSectionFee() {
		return sectionFee;
	}

	public void setSectionFee(double sectionFee) {
		this.sectionFee = sectionFee;
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
		return "Section [Name=" + Name + ", Rows=" + Arrays.toString(Rows) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + Arrays.hashCode(Rows);
		long temp;
		temp = Double.doubleToLongBits(sectionFee);
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
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (!Arrays.equals(Rows, other.Rows))
			return false;
		if (Double.doubleToLongBits(sectionFee) != Double.doubleToLongBits(other.sectionFee))
			return false;
		return true;
	}


	
}
