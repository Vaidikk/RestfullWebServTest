package com.riptide.services;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/productAdd")
public class HelloFormParam {
	
	@POST
	@Path("/add")
	@Produces("text/html")
	public Response addProduct(@FormParam("id") int id, @FormParam("name") String name, @FormParam("price") double price) {
		String opString = "<p>Product add successfully! "
				+ "<br>Product Id: "+id
				+"<br>Name: "+name
				+"<br>Price: "+price+"</p>";
		return Response
				.status(200)
				.entity(opString)
				.build();
	}
}
