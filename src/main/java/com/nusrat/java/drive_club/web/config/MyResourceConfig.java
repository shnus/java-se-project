package com.nusrat.java.drive_club.web.config;

/**
 * Created by Nusrat on 2/14/2017.
 */

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.sse.SseFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class MyResourceConfig extends ResourceConfig {
    public MyResourceConfig() {
        packages("com.nusrat.java.drive_club");
        packages("org.glassfish.jersey.examples.jackson");
        register(LoggingFilter.class);
        register(JspMvcFeature.class);
        register(SseFeature.class);
        register(JacksonFeature.class);
       // register(MyApplicationBinder.class);
        property("jersey.config.server.mvc.templateBasePath.jsp", "/WEB-INF/jsp");
        property("jersey.config.server.provider.classnames", "org.glassfish.jersey.server.mvc.jsp.JspMvcFeature");
        property("jersey.config.server.provider.classnames", "org.glassfish.jersey.media.multipart.MultiPartFeature");
        property("jersey.config.server.tracing", "ALL");
        property("jersey.config.servlet.filter.staticContentRegex","/(resources|static)/.*");

    }
}
