package org.acme.amqp;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 */
@Path("/machineCodec")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MachineCodecResource {

    @Inject
    @Channel("codec")
    Emitter<String> emitter;

    @POST
    @Path("/operation")
    public String sendOperation(String operation) {
        System.out.println("MachineCodecResource sendOperation = " + operation);
        emitter.send(operation);
        return "hello";
    }

}
