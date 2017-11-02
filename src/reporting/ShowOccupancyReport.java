package reporting;

import seating.*;
import thalia.Show;

public class ShowOccupancyReport extends ShowReport {
	int seats_sold=0;
	int available_seats=0;
	double occupancy;
	public ShowOccupancyReport(Show show){
		this.show = show;
		this.seats_sold= 0;
		this.available_seats=0;
		updateOccupancyMetrics();
		this.occupancy=(this.seats_sold/(this.available_seats+this.seats_sold))*100;
	}
	public ShowOccupancyReport(Show show, int seats_sold, int available_seats, double occupancy) {
		this.show = show;
		this.seats_sold = seats_sold;
		this.available_seats = available_seats;
		this.occupancy = occupancy;
	}
	private void updateOccupancyMetrics(){
		for(Section section: this.show.getSeating_info()){
			SectionReport sr = new SectionReport(section);
			this.available_seats+=sr.getSeats_available();
			this.seats_sold+=sr.getSeats_sold();
		}
	}
	public int getSeats_sold() {
		return seats_sold;
	}
	public void setSeats_sold(int seats_sold) {
		this.seats_sold = seats_sold;
	}
	public int getAvailable_seats() {
		return available_seats;
	}
	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
	}
	public double getOccupancy() {
		return occupancy;
	}
	public void setOccupancy(double occupancy) {
		this.occupancy = occupancy;
	}
	

}
