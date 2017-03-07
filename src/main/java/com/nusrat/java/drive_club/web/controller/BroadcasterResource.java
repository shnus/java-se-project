package com.nusrat.java.drive_club.web.controller;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseBroadcaster;
import org.glassfish.jersey.media.sse.SseFeature;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by Nusrat on 3/7/2017.
 */
@Singleton
@Path("broadcast")
public class BroadcasterResource {

    private SseBroadcaster broadcaster = new SseBroadcaster();

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String broadcastMessage(String message) {
        OutboundEvent.Builder eventBuilder = new OutboundEvent.Builder();
        OutboundEvent event = eventBuilder.name("message")
                .mediaType(MediaType.TEXT_PLAIN_TYPE)
                .data(String.class, message)
                .build();

        broadcaster.broadcast(event);
        System.out.println("DONE MESSAGE");
        return "Message '" + message + "' has been broadcast.";
    }
    @GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput getServerSentEvents() {
        final EventOutput eventOutput = new EventOutput();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(1000);
                        final OutboundEvent.Builder eventBuilder = new OutboundEvent.Builder();
                        eventBuilder.data(String.class, "Hello world " + i + "!");
                        final OutboundEvent event = eventBuilder.build();
                        eventOutput.write(event);
                    }
                } catch (Exception e) {
                    // Exception handling
                } finally {
                    try {
                        eventOutput.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return eventOutput;
    }
}
