package com.bao.shadowhunter;

import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public abstract class MessageListener {

    public Mono<Void> processCommand(Message eventMessage) {
        return Mono.just(eventMessage)
                .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
                .filter(message -> message.getAuthor().map(user -> user.getId().asString().equals("280446386066030592")).orElse(false))
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage("Tg Jules"))
                .then();
    }
}
