package com.wwe.wweapi.port.primary.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("wrestler")
public interface WrestlerEndpoint{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response getAll();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    Response getByID(@PathParam("id") String id);
}