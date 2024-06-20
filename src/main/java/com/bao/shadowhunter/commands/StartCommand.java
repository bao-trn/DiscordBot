package com.bao.shadowhunter.commands;

import com.bao.shadowhunter.game.Game;
import com.bao.shadowhunter.interfaces.GameCommands;
import com.bao.shadowhunter.services.GameService;
import com.bao.shadowhunter.utils.MessageUtils;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;


public class StartCommand implements GameCommands {

    private final GameService gameService;

    public StartCommand(GameService service) {
        this.gameService = service;
    }

    @Override
    public String getName() {
        return "!start";
    }

    @Override
    public Mono<Void> handle(Game game, Message event) {
        game.initPlayerCards();
        game.initZones();
        game.getPlayers().forEach((user, playerCard) -> MessageUtils.whisperMessage(user, MessageUtils.createPlayerSpec(playerCard)));
        return MessageUtils.createMessage(event, "Starting game!")
                .then(MessageUtils.createMessage(event, "Player Cards sent to each players"))
                .then(gameService.runGame(game, event));

    }
}
