package com.example.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/Order/")
public interface OrderInfo {
	@GET
	@Produces("application/text")
	@Path("/{cloud}/{operation}/{command}")
	public String getOrder(@PathParam("cloud") String cloud, @PathParam("operation") String operation,
			@PathParam("command") String command);

	@POST
	@Produces("application/xml")
	@Path("All")
	public OrderList getAllOrders();
}
