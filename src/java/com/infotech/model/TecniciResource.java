/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotech.model;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author andreapollini
 */
@Path("tecnici")
public class TecniciResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TecniciResource
     */
    public TecniciResource() {
    }

    @POST
    public Response createTecnico(String body) {
        Gson g = new Gson();
        Tecnico t = g.fromJson(body, Tecnico.class);
        boolean saveRet = InfotechDAO.save(t);
        if (saveRet == true)
            return Response.ok().build();
        else
            return Response.serverError().build();
    }
    
    /**
     * Retrieves representation of an instance of com.infotech.model.TecniciResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    
}
