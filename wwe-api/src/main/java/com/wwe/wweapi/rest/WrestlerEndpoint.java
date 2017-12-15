package com.wwe.wweapi.rest;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wwe.wweapi.object.Wrestler;
import org.springframework.stereotype.Component;

//TODO : Make Response objects
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