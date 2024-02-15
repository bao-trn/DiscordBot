package com.bao.shadowhunter.utils;

import com.bao.shadowhunter.entities.PlayerCard;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;
import reactor.core.publisher.Mono;

import java.util.List;

public class MessageUtils {

    public static EmbedCreateSpec createPlayerSpec(PlayerCard playerCard) {
         return EmbedCreateSpec.builder()
                .color(Color.RED)
                .title(playerCard.getName())
                .description("Team " + playerCard.getTeam()).thumbnail(playerCard.getTeamThumbnail())
                .addField("Win Condition", playerCard.getWinCondition(), false)
                .addField("Ability", playerCard.getAbility(), false)
                .addField("Health Points (HP)", String.valueOf(playerCard.getStartingHp()), true)
                 .image(playerCard.getCardImageURL())
                .build();
    }

    public static Mono<Void> createMessage(Message event, String msg) {
        return Mono.just(event)
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage(msg))
                .then();
    }

    public static Mono<Void> createMessage(Message event, EmbedCreateSpec spec) {
        return Mono.just(event)
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage(spec))
                .then();
    }

    public static void whisperMessage(User user, String msg) {
        user.getPrivateChannel()
                .flatMap(privateChannel -> privateChannel.createMessage(msg))
                .subscribe();
    }

    public static void whisperMessage(User user, EmbedCreateSpec spec) {
        user.getPrivateChannel()
                .flatMap(privateChannel -> privateChannel.createMessage(spec))
                .subscribe();
    }

    public static void whisperList(List<User> users, String msg) {
        users.forEach(user -> user.getPrivateChannel()
                .flatMap(channel -> channel.createMessage(msg))
                .subscribe());
    }

}
