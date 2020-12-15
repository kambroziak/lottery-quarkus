package pl.kambroziak.quarkus;

import org.eclipse.microprofile.reactive.messaging.Incoming;

public class Receiver {

    @Incoming("lottery-numbers")
    public void receive(String gameDescriptor){
        System.out.println(gameDescriptor);
        throw new RuntimeException("on purpose exception");
    }

    @Incoming("lottery-numbers-dlq")
    public void receiveDlq(String gameDescriptor){
        System.out.println("dlq: "+gameDescriptor);
    }

}
