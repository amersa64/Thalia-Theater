package reporting;

import java.time.LocalDate;


import seating.*;
import thalia.*;

public class TheatreRevenueReport extends TheatreReport{
	double overall_revenue=0;
	public TheatreRevenueReport(){
		super();
		updateRevene();
	}
	public TheatreRevenueReport(LocalDate startDate, LocalDate endDate){
		super(startDate,endDate);
		updateRevene();
	}
	public void updateRevene(){
		for(Show show: theatre.getShows()){
			for(Section section:show.getSeating_info()){
				SectionRevenueReport srr = new SectionRevenueReport(section);
				overall_revenue+=srr.getSection_revenue();
			}
		}
	}
	public double getOverall_revenue() {
		return overall_revenue;
	}
	public void setOverall_revenue(double overall_revenue) {
		this.overall_revenue = overall_revenue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(overall_revenue);
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
		TheatreRevenueReport other = (TheatreRevenueReport) obj;
		if (Double.doubleToLongBits(overall_revenue) != Double.doubleToLongBits(other.overall_revenue))
			return false;
		return true;
	}
	

}
