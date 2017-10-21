package edu.iit.cs445.thalia;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;


	//Sets the path to base URL + /hello
	@Path("/hello")
	public class Thalia {
	 // This method is called if TEXT_PLAIN is request
//	 @GET
//	 @Produces(MediaType.TEXT_PLAIN)
//	 public String sayPlainTextHello() {
//	 return "Hello Jersey 222- plain text\n";
//	 }
	 // This method is called if HTML is request
	 @GET
	 @Produces(MediaType.TEXT_HTML)
	 public String sayHtmlHello() throws JSONException {
		return dummy.myF();

	 }
	}
