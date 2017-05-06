package com.nusrat.java.drive_club.web.filter;

/**
 * Created by Nusrat on 2/12/2017.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.net.URI;

@Provider
public class AuthorizationRequestFilter implements ContainerRequestFilter {

    @Context
    private HttpServletRequest servletRequest;

    @Context
    private HttpServletResponse servletResponse;

    public void filter(ContainerRequestContext requestContext)
            throws IOException {

        HttpSession session = servletRequest.getSession();
        final boolean isLoggedIn = session != null && session.getAttribute("user") != null;
        String baseUri = requestContext.getUriInfo().getBaseUri().toString();
        String path = requestContext.getUriInfo().getPath();
        System.out.println(path);
        if(!path.startsWith("login")&& !path.startsWith("locale")&& !path.startsWith("logon") && !isLoggedIn){
            requestContext.abortWith(Response.seeOther(URI.create(baseUri+"login")).build());
        }
        /*
        if (securityContext == null ||
                !securityContext.isUserInRole("privileged")) {

            requestContext.abortWith(Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("User cannot access the resource.")
                    .build());
        }*/
    }
}