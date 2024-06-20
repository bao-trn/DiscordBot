package com.bao.shadowhunter.services;

import com.bao.shadowhunter.game.Game;
import com.bao.shadowhunter.utils.MessageUtils;
import discord4j.core.event.domain.interaction.ButtonInteractionEvent;
import discord4j.core.object.entity.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class GameService {



    public Mono<Void> runGame(Game game, Message event) {

        if (!game.getPlayers().isEmpty()) {
            return event.getChannel()
                    .flatMap(channel -> {
                        Mono<Message> messageMono = channel.createMessage(MessageUtils.createButton("start", "START"));
                        Mono<Void> listener = channel.getClient().on(ButtonInteractionEvent.class, e -> {
                                    if (e.getCustomId().equals("start")) {
                                        return e.edit("")
                                                .then(MessageUtils.createMessage(event,MessageUtils.createBoardSpec(game)));
                                    }
                                    return e.edit("Game has ended");
                                }).timeout(Duration.ofMinutes(5))
                                .then();
                        return messageMono
                                .then(listener);
                        });
        }

        return MessageUtils.createMessage(event, "Game ended");
    }

}
