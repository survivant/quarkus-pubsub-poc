package org.acme.amqp;

import io.smallrye.reactive.messaging.annotations.Merge;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MachineMessageConsumer2 {

    @Incoming("ops")
    @Merge
    public void processMessage(String message) {
        System.out.println(MachineMessageConsumer2.class +  " MESSAGE RECU = " + message);
    }

}
