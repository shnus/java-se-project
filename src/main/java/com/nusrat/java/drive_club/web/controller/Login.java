package com.nusrat.java.drive_club.web.controller;

import com.nusrat.java.drive_club.dao.DriverUserDao;
import com.nusrat.java.drive_club.model.Credentials;
import com.nusrat.java.drive_club.model.User;
import com.nusrat.java.drive_club.service.DriverSecurityService;
import com.nusrat.java.drive_club.service.DriverUserService;
import com.nusrat.java.drive_club.service.Validation;
import com.nusrat.java.drive_club.service.interfaces.UserService;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Optional;

/**
 * Created by Nusrat on 2/14/2017.
 */
@Path("/login")
public class Login {
    @Context
    private HttpServletRequest servletRequest;

    @Context
    private HttpServletResponse servletResponse;

    @Context
    UriInfo uri;


    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response loginPage() {
        return Response.ok(new Viewable("/login/index.jsp")).build();
    }

    UserService userService = new DriverUserService(new DriverUserDao(new DriverSecurityService()), new DriverSecurityService());

    @POST
    public Response signIn(@FormParam("login") String login, @FormParam("password") String password){
        Credentials credentials = Credentials.builder()
                .login(login)
                .password(password)
                .build();

        final Validation validation  = Validation.builder().build();
        final Optional<User> user = userService.getByCredentials(credentials);

        if(!user.isPresent()){
            validation.getValid().put("INVALID_CREDENTIALS", true);
            servletRequest.setAttribute("validation",validation);
            return Response.ok(new Viewable("/login/index.jsp")).build();
        } else {
            servletRequest.getSession(true).setAttribute("user",user.get());
            servletRequest.getSession(true).setAttribute("isLogin",true);
        }

        return Response.seeOther(uri.getBaseUri()).build();
    }
}
