package com.nusrat.java.drive_club.web.config;

/**
 * Created by Nusrat on 2/14/2017.
 */
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class MyResourceConfig extends ResourceConfig {
    public MyResourceConfig() {
        packages("com.nusrat.java.drive_club.web");
        register(LoggingFilter.class);
        register(JspMvcFeature.class);
        property("jersey.config.server.mvc.templateBasePath.jsp", "/WEB-INF/jsp");
        property("jersey.config.server.provider.classnames", "org.glassfish.jersey.server.mvc.jsp.JspMvcFeature");
        property("jersey.config.server.tracing", "ALL");
        property("jersey.config.servlet.filter.staticContentRegex","/(resources|static)/.*");

    }
}
