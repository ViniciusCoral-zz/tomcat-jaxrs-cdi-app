package br.com.coral.jaxrs_cdi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/cliente")
@Produces("application/json")
@RequestScoped
public class ClienteWS {

	@Inject
	private ClienteDAO dao;
	
	@GET
    @Path("hello")
	@Produces("application/text")
    public String helloworld() {
        return "Hello World!";
    }
	
	@GET
    @Path("{id}")
    public Response testeDao(@PathParam("id") int id) {
        return Response.ok(dao.getCliente(id)).build();
    }
	
	@POST
	public Response cadastrarCliente(String nome) {
		dao.cadastrar(nome);
		return Response.ok().build();
	}
	
}
