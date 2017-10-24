package gui;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.iit.cs445.thalia.Show;
import edu.iit.cs445.thalia.testVals;
import seating.*;


//Sets the path to base URL + /test
@Path("/shows")
public class ShowsAPI {
	 
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Show CreateShow(){
		Show sh = new Show();
		return sh;
	}
	
	@PUT
	@Path("/{wid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void UpdateShow(@PathParam("wid") int wid){
		 
	}
	 
	@GET
	@Path("/{wid}")
	@Produces(MediaType.APPLICATION_JSON)
//	public Show ViewShow(@PathParam("wid") int wid){
	public Show ViewShow(@PathParam("wid") String wid){
			if (wid.equals(null)){
				return null;
			}
			return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Show[] ViewAllShows(){
		Theatre theatres= new Theatre();
		LocalTime time = LocalTime.of(11, 40, 50);
		LocalDate date = LocalDate.of(2017, 10, 28);
		int length = 120;
		String description = "Test Description";
		Show sh = new Show(time, date, theatres, 0, length, description);
		Show[] shows = {sh};
		
		return shows;
	}
	 
	@GET
	@Path("/{wid}/sections")
	@Produces(MediaType.APPLICATION_JSON)
	public testVals[] ViewShowSections(@PathParam("wid") int wid){
		testVals tv = new testVals();
		testVals[] tva = {tv, tv, tv};
		return tva;	 
	}
}
