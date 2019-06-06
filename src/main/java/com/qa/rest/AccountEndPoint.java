package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.service.AccountService;

@Path("/account")
public class AccountEndPoint {

	@Inject
	private AccountService service;

	@Path("/getAllMovies")
	@GET
	@Produces({ "application/json" })
	public String getAllMovies() {
		return service.getAllMovies();
	}
}
