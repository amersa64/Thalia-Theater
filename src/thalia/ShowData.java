package thalia;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShowData {
	private String name;
	private String web;
	private LocalTime time;
	private LocalDate date;

	public ShowData(){
		
	}
	public ShowData(String name, String web, LocalTime time, LocalDate date) {
		this.name = name;
		this.web = web;
		this.time = time;
		this.date = date;
	}
	
	
	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}