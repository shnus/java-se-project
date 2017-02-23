package com.nusrat.java.drive_club.web.controller;

import com.nusrat.java.drive_club.model.Credentials;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Nusrat on 2/14/2017.
 */
@Path("/login")
public class Login {
    @Context
    private HttpServletRequest servletRequest;

    @Context
    private HttpServletResponse servletResponse;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response loginPage() {
        return Response.ok(new Viewable("/login/index.jsp")).build();
    }

    @POST
    public Response signIn(@FormParam("login") String login, @FormParam("password") String password){
        Credentials credentials = Credentials.builder()
                .login(login)
                .password(password)
                .build();
        return Response.ok(new Viewable("/index.jsp")).build();
    }
}
