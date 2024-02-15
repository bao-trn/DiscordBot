package com.bao.shadowhunter.interfaces;

import com.bao.shadowhunter.commands.*;
import com.bao.shadowhunter.game.Game;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collection;

public interface GameCommands {

    String getName();
    Mono<Void> handle(Game game, Message event);


    static Collection<GameCommands> init() {
        Collection<GameCommands> collection = new ArrayList<>();
        collection.add(new PingCommand());
        collection.add(new CreateCommand());
        collection.add(new JoinCommand());
        collection.add(new StartCommand());
        collection.add(new TestCommand());
        return collection;
    }

}
