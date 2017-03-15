package com.nusrat.java.drive_club.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Created by Nusrat on 2/11/2017.
 */
@Path("/locale")
public class LocaleChangeResource {
    @Context
    private HttpServletRequest servletRequest;

    @Context
    private HttpServletResponse servletResponse;

    @POST
    public Response helloWorld(@FormParam("locale") String locale, @FormParam("redirect_to") String redirectTo) {
        HttpSession session = servletRequest.getSession(true);
        session.setAttribute("locale", locale);

        if (redirectTo != null) {
            return Response.seeOther(URI.create(redirectTo)).build();
        } else {
            return Response.seeOther(URI.create(servletRequest.getContextPath())).build();
        }
    }
}