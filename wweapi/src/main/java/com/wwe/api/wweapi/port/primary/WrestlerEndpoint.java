package com.wwe.api.wweapi.port.primary;

import com.wwe.api.wweapi.domain.model.Wrestler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
