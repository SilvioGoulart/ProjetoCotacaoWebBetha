package org.bairro.apistart.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ola")
@Produces(MediaType.TEXT_PLAIN)
public class HelloResource {

	@GET
	public String ola() {
		return "Olá, sua API está rodando...";
	}
	
}
