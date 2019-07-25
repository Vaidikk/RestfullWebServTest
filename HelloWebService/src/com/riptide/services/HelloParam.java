package com.riptide.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/ripparam")
public class HelloParam {
	
	@Path("/welcome/{nm}")
	@GET
	@Produces("text/html")
	public Response getMessage(@PathParam("nm") String name) {
		return Response
				.status(200)
				.entity("<p>Hello <b>"+name+"</b> Welcome to the Service</p>")
				.build();
	}
	
	@Path("/welcome/{dd}/{mm}/{yyyy}")
	@GET
	@Produces("text/html")
	public Response getMessage(@PathParam("dd") int day, @PathParam("mm") int month, @PathParam("yyyy") int year) {
		
		LocalDate date = LocalDate.of(year, month, day);
		DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern("DD/MM/YYYY");
		
		return Response
				.status(200)
				.entity("<p>Your birthday, in case you didn't know: <b>"+date.format(dFormatter)+"</b> Cheers!!</p>")
				.build();
	}
}
