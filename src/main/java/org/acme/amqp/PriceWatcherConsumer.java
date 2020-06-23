package org.acme.amqp;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

/**
 * A bean consuming data from the "prices" AMQP queue and applying some conversion.
 * The result is pushed to the "my-data-stream" stream which is an in-memory stream.
 */
@ApplicationScoped
public class PriceWatcherConsumer {

    @Incoming("prices")
    public void process(int priceInUsd) {
        System.out.println("PRIX RECU = " + priceInUsd);
    }

    @Incoming("ops")
    public void processMessage(String message) {
        System.out.println(PriceWatcherConsumer.class +  " MESSAGE RECU = " + message);
    }

}
