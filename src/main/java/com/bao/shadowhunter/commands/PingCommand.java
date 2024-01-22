package com.bao.shadowhunter.commands;

import com.bao.shadowhunter.game.Game;
import com.bao.shadowhunter.interfaces.GameCommands;
import com.bao.shadowhunter.utils.MessageUtils;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public class PingCommand implements GameCommands {

    @Override
    public String getName() {
        return "!ping";
    }

    @Override
    public Mono<Void> handle(Game game, Message event) {
        return MessageUtils.createMessage(event, "Pong!");
    }


}
