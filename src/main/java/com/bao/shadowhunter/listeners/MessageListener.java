package com.bao.shadowhunter.listeners;

import com.bao.shadowhunter.game.Game;
import com.bao.shadowhunter.interfaces.GameCommands;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

@Service
public class MessageListener {

    /* Listens to basic message creation */
    private final Collection<GameCommands> gameCommands;
    private final Game game;
    public MessageListener (GatewayDiscordClient client) {
        gameCommands = GameCommands.init();
        game = new Game();
        client.on(MessageCreateEvent.class)
                .flatMap(this::processCommand)
                .onErrorResume(this::handleError)
                .subscribe();

    }

    private Publisher<Void> handleError(Throwable throwable) {
        return Mono.empty();
    }

    public Mono<Void> processCommand(MessageCreateEvent event) {
        Message msg = event.getMessage();
        String msgContent = msg.getContent();

        return Flux.fromIterable(gameCommands)
                .filter(command -> command.getName().equals(msgContent))
                .next()
                .flatMap(command -> command.handle(game, msg));
    }

}
