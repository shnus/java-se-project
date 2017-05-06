package com.nusrat.java.drive_club.web.controller;

import com.nusrat.java.drive_club.model.UserBean;
import com.nusrat.java.drive_club.service.UserServiceImpl;
import com.nusrat.java.drive_club.service.Validation;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by Nusrat on 3/17/2017.
 */
@Path("/logon")
public class LogonResource {
    @Context
    private HttpServletRequest servletRequest;

    @Context
    private HttpServletResponse servletResponse;

    @Context
    UriInfo uri;

    @Inject
    UserServiceImpl userService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response loginPage() {
        return Response.ok(new Viewable("/logon/index.jsp")).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public Response broadcastMessage(UserBean user) {
        final Validation validation  = userService.checkUser(user);
        if(!validation.getValid().isEmpty()){
            servletRequest.setAttribute("validation",validation);
            return Response.ok(new Viewable("/logon/index.jsp")).build();
        }
        userService.createUser(user);
        return Response.ok(new Viewable("/logon/index.jsp")).build();
    }

}
