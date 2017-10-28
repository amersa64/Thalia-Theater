package reporting;

import java.time.LocalDate;
import java.util.ArrayList;

import thalia.Show;
import thalia.Theatre;

public class TheatreReport {

	protected LocalDate startDate;
	protected LocalDate endDate;
	protected Theatre theatre;
	protected int total_shows;
	protected int total_seats;
	protected int sold_seats;

	public TheatreReport(LocalDate startDate, LocalDate endDate) {
		this.theatre= Theatre.getInstance();
		this.total_shows=theatre.getShows().size();
		this.startDate=startDate;
		this.endDate=endDate;
		constructorHelper();
	}
	public TheatreReport(){
		this.theatre= Theatre.getInstance();
		this.total_shows=theatre.getShows().size();
		this.startDate=null;
		this.endDate=null;
		constructorHelper();
	}
	private void constructorHelper(){
		total_seats=0;
		sold_seats=0;
		ArrayList<Show> shows = theatre.getShowsBetweenDates(startDate, endDate);
		for(Show show: shows){
			ShowOccupancyReport showreport = new ShowOccupancyReport(show);
			total_seats+=(showreport.getAvailable_seats()+showreport.getSeats_sold());
			sold_seats+=showreport.getSeats_sold();
		}
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public int getTotal_shows() {
		return total_shows;
	}

	public void setTotal_shows(int total_shows) {
		this.total_shows = total_shows;
	}

	public int getTotal_seats() {
		return total_seats;
	}

	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}

	public int getSold_seats() {
		return sold_seats;
	}

	public void setSold_seats(int sold_seats) {
		this.sold_seats = sold_seats;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + sold_seats;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((theatre == null) ? 0 : theatre.hashCode());
		result = prime * result + total_seats;
		result = prime * result + total_shows;
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
		TheatreReport other = (TheatreReport) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (sold_seats != other.sold_seats)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (theatre == null) {
			if (other.theatre != null)
				return false;
		} else if (!theatre.equals(other.theatre))
			return false;
		if (total_seats != other.total_seats)
			return false;
		if (total_shows != other.total_shows)
			return false;
		return true;
	}

}