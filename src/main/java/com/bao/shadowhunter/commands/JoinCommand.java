package com.bao.shadowhunter.commands;

import com.bao.shadowhunter.game.Game;
import com.bao.shadowhunter.interfaces.GameCommands;
import com.bao.shadowhunter.utils.MessageUtils;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class JoinCommand implements GameCommands {
    @Override
    public String getName() {
        return "!join";
    }

    @Override
    public Mono<Void> handle(Game game, Message event) {
        Optional<User> author = event.getAuthor();

        return author.map(user -> {
            game.addPlayer(user);
            return MessageUtils.createMessage(event, user.getUsername() + " just joined the game");
        }).orElseGet(() -> MessageUtils.createMessage(event, "error joining the game"));
    }

}
