package com.bao.shadowhunter.services;

import com.bao.shadowhunter.entities.PlayerCard;
import discord4j.core.object.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GameService {

    public void initPlayerCards(Map<User, PlayerCard> players) {
        int numberOfPlayers = players.size();
        if (numberOfPlayers % 3 == 0) {
            //players.get()
        }
    }

}
