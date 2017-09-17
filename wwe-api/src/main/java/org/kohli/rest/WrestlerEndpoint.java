package org.kohli.rest;

import java.util.List;
import org.kohli.object.Wrestler;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("wrestler")
public interface WrestlerEndpoint{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Wrestler> getAll();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    Wrestler getByID(@PathParam("id") String id);
}