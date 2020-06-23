package org.acme.amqp;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MachineMessageConsumer {

    @Incoming("ops")
    public void processMessage(String message) {
        System.out.println(MachineMessageConsumer.class +  " MESSAGE RECU = " + message);
    }

}
