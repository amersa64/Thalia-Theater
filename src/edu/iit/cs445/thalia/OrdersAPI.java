package edu.iit.cs445.thalia;
import java.text.SimpleDateFormat;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//Sets the path to base URL + /test
@Path("/orders")
public class OrdersAPI {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String CreateOrder(){
		return "CreateOrder";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String ViewOrdersByDate(@QueryParam("start_date") SimpleDateFormat start_date, @QueryParam("end_date") SimpleDateFormat end_date){
		if (start_date == null && end_date == null){
			return "ViewAllOrders";
		}
		if (start_date != null && end_date != null){
			return "ViewOrdersByDate";
		}
		return "Invalid Entry";
	}
	
	@GET
	@Path("/{oid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String ViewOrder(@PathParam("oid") String oid){
		return oid;
	}
}
