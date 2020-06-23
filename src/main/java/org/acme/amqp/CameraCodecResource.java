package org.acme.amqp;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 */
@Path("/cameraCodec")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CameraCodecResource {

    @POST
    @Path("/operation")
    //@Outgoing("codec")
    //@Broadcast
    public String sendOperation(String operation) {
        System.out.println("CameraCodecResource sendOperation = " + operation);

        return "hello";
    }

    //@Incoming("codec")
    public void handleMessage(String message){
        System.out.println("CameraCodecResource received " + message);
    }

}
