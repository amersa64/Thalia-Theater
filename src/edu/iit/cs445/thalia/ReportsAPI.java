package edu.iit.cs445.thalia;
import javax.ws.rs.PathParam;

import java.text.SimpleDateFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//Sets the path to base URL + /test
@Path("/reports")
public class ReportsAPI {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String GetListOfAvailableReports(){
		return "GetListOfAvailableReports";
	}
	
	@GET
	@Path("/{mrid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String GetReport(@PathParam("mrid") String mrid, @QueryParam("start_date") SimpleDateFormat start_date, @QueryParam("end_date") SimpleDateFormat end_date){
		
		return mrid;
	}

}