package com.nusrat.java.drive_club.web.controller;

import org.glassfish.jersey.media.sse.SseBroadcaster;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Nusrat on 3/7/2017.
 */
@Singleton
@Path("broadcast")
public class BroadcasterResource {

    static String mes = "Default message ";

    private SseBroadcaster broadcaster = new SseBroadcaster();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String broadcastMessage(Person person) {
        System.out.println("Принял");
        return "nice";
    }

    @Path("get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person getServerSentEvents() {
        Person per = new Person("get inp");
        return per;
    }
}
