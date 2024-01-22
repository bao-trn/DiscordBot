package com.bao.shadowhunter.utils;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import reactor.core.publisher.Mono;

import java.util.List;

public class MessageUtils {

    public static Mono<Void> createMessage(Message event, String msg) {
        return Mono.just(event)
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage(msg))
                .then();
    }

    public static void whisperMessage(User user, String msg) {
        user.getPrivateChannel()
                .flatMap(privateChannel -> privateChannel.createMessage(msg))
                .subscribe();
    }

    public static void whisperList(List<User> users, String msg) {
        users.forEach(user -> user.getPrivateChannel()
                .flatMap(channel -> channel.createMessage(msg))
                .subscribe());
    }

}
