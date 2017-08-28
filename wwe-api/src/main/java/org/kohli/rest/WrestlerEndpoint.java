package org.kohli.rest;

import java.util.List;
import org.kohli.object.Wrestler;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

@Component
@Path("api/v1")
public interface WrestlerEndpoint{

    @GET
    @Produces("application/json")
    List<Wrestler> getAll();

    @GET
    @Produces("application/json")
    @Path("/{id}")
    Wrestler getByID(@PathParam("id") String id);
}