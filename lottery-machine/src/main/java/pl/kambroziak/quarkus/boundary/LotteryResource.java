package pl.kambroziak.quarkus.boundary;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import pl.kambroziak.quarkus.entity.GameDescriptor;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

@Path("/play")
public class LotteryResource {

    @Inject
    @Channel("lottery-numbers")
    Emitter<GameDescriptor> emitter;

    @GET
    public void play(@QueryParam("level") Integer level) {
        System.out.println("in emit");
        GameDescriptor payload = new GameDescriptor(getNumbers(), Optional.ofNullable(level).orElse(1));

        Message<GameDescriptor> message = Message.of(payload, Collections.emptyList(), () -> CompletableFuture.runAsync(() ->
                System.out.println("Ack received")),s->CompletableFuture.runAsync(()-> System.out.println("nack")));

        emitter.send(message);


        System.out.println("after emit");
    }

    private List<Integer> getNumbers() {
        return new Random().ints(6, 1, 50)
                .boxed()
                .collect(Collectors.toList());
    }

}
