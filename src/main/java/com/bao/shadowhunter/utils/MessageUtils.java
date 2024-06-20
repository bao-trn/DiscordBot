package com.bao.shadowhunter.utils;

import com.bao.shadowhunter.entities.PlayerCard;
import com.bao.shadowhunter.entities.Zone;
import com.bao.shadowhunter.game.Game;
import discord4j.core.event.domain.interaction.ButtonInteractionEvent;
import discord4j.core.object.component.ActionRow;
import discord4j.core.object.component.Button;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.MessageCreateSpec;
import discord4j.rest.util.Color;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.bao.shadowhunter.constants.MessageConstants.JOIN_ID;
import static com.bao.shadowhunter.constants.MessageConstants.JOIN_LABEL;

public class MessageUtils {

    public static Mono<Void> handleJoin(Game game, Message event) {
        return event.getChannel()
                .flatMap(channel -> {
                    Mono<Message> messageMono = channel.createMessage(createButton(JOIN_ID, JOIN_LABEL));
                    Mono<Void> listener = channel.getClient().on(ButtonInteractionEvent.class, e -> {
                                if (e.getCustomId().equals(JOIN_ID)) {
                                    game.addPlayer(e.getInteraction().getUser());
                                    List<String> players = new ArrayList<>();
                                    game.getPlayers().forEach((k,v) -> players.add(k.getUsername()));
                                    return e.edit(String.join(System.lineSeparator(), players));
                                } else {
                                    return Mono.empty();
                                }
                            }).timeout(Duration.ofMinutes(5))
                            .then();
                    return messageMono
                            .then(listener);
                });
    }

    public static MessageCreateSpec createButton(String customId, String label) {
        Button button = Button.success(customId, label);
        return MessageCreateSpec.builder()
                .addComponent(ActionRow.of(button))
                .build();
    }

    public static EmbedCreateSpec createPlayerSpec(PlayerCard playerCard) {
         return discord4j.core.spec.EmbedCreateSpec.builder()
                .color(Color.RED)
                .title(playerCard.getName())
                .description("Team " + playerCard.getTeam()).thumbnail(playerCard.getTeamThumbnail())
                .addField("Win Condition", playerCard.getWinCondition(), false)
                .addField("Ability", playerCard.getAbility(), false)
                .addField("Health Points (HP)", String.valueOf(playerCard.getStartingHp()), true)
                 .image(playerCard.getCardImageURL())
                .build();
    }

    public static EmbedCreateSpec createBoardSpec(Game game) {
        EmbedCreateSpec.Builder builder = EmbedCreateSpec.builder();
                addZoneFields(builder, game);
                return builder.build();
    }

    private static void addZoneFields(EmbedCreateSpec.Builder builder, Game game) {
        List<Zone> zones = game.getZones();
        zones.forEach(zone -> {
            builder.addField("LIEU[" + zone.getId() + "]", "", false);
            //zone.getZones().
        } );
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

    public static Mono<Void> createMessage(Message event, MessageCreateSpec spec) {
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

    private MessageUtils() {}

}
