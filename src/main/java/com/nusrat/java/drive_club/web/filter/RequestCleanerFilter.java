package com.nusrat.java.drive_club.web.filter;

/**
 * Created by Nusrat on 2/28/2017.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import java.io.IOException;



@Provider
public class RequestCleanerFilter implements ContainerRequestFilter {

    @Context
    private HttpServletRequest servletRequest;

    @Context
    private HttpServletResponse servletResponse;

    public void filter(ContainerRequestContext requestContext)
            throws IOException {
        HttpSession session = servletRequest.getSession();
        if(servletRequest.getAttribute("validation")!=null){
            System.out.println("It works!");
          //  servletRequest.removeAttribute("validation");
        } else {
            System.out.println("It dont works!");
        }

    }
}