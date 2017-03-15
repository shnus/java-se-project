package com.nusrat.java.drive_club.web.controller;


import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Nusrat on 2/16/2017.
 */
@Path("")
public class HomeResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response homePage(){
        return Response.ok(new Viewable("/index.jsp")).build();
    }
}
