package org.bairro.apistart.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.bairro.apistart.entidades.Cotacoes;
import org.bairro.apistart.services.CotacoesServices;
import org.bairro.apistart.utils.MensagemResposta;

@Path("cotacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CotacoesResources {

	@Inject
	CotacoesServices service;

	@GET
	public Response getAll() {
		return Response.ok(service.getAll()).build();
	}

	@GET
	@Path("{id}")
	public Response getById(@PathParam("id") Integer id) {
		try {
			return Response.ok(service.getById(id)).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("produto/{id}")
	public Response getByIdProduto(@PathParam("id") Integer id) {
		try {
			return Response.ok(service.getById(id)).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}

	@POST
	public Response save(Cotacoes entity) {
		try {
			return Response.ok(service.salvar(entity)).status(Status.CREATED).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}

	@PUT
	public Response update(Cotacoes entity) {
		try {
			return Response.ok(service.atualizar(entity)).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}

	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Integer id) {
		try {
			service.deletar(id);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
}