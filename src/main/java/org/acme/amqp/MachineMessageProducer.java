package org.acme.amqp;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

/**
 * A bean consuming data from the "prices" AMQP queue and applying some conversion.
 * The result is pushed to the "my-data-stream" stream which is an in-memory stream.
 */
@ApplicationScoped
public class MachineMessageProducer {

    @Incoming("codec")
    @Outgoing("ops")
    @Broadcast
    public String handleMessage(String message){
        System.out.println("MachineMessageProducer handleMessage received " + message);
        return message;
    }

    @Incoming("internal-codec")
    @Outgoing("codec")
    @Broadcast
    public String dispatch(String message) {
        System.out.println("MachineMessageProducer dispatch received " + message);
        return message;
    }

}
