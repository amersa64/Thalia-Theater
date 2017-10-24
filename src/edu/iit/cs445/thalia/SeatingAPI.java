package edu.iit.cs445.thalia;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//Sets the path to base URL + /test
@Path("/seating")
public class SeatingAPI {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String RequestSeats(@QueryParam("show") String wid, @QueryParam("section") String sid, @QueryParam("count") int count, @QueryParam("seats") List<Integer> cid){
		
		//Request Seats Auto
		if (!wid.equals("") && !sid.equals("") && count!=0 && cid.size()== 0){
			return "Request Seats Auto";
		}
		
		//Request Specific Seats
		if (!wid.equals("") && !sid.equals("") && count==0 && cid.size()!= 0){
			return "Request Specific Seats of value " + String.valueOf(cid.size());
		}
		return "Invalid Entry";
		
	}

	
	@GET
	@Path("/{sid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String ViewSpecificSeats(@PathParam("sid") String sid) {
		return sid;
	}
}
