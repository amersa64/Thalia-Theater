package edu.iit.cs445.thalia;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Sets the path to base URL + /test
@Path("/tickets")
public class TicketsAPI {
	
	@GET
	@Path("/{tid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String ViewTicket(@PathParam("tid") String tid){
		return "ViewTicket";
	}
	
	@PUT
	@Path("/{tid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String UpdateTicket(@PathParam("tid") String tid){
		return tid;
	}
}
