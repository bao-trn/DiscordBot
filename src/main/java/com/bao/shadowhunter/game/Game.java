package com.bao.shadowhunter.game;

import com.bao.shadowhunter.entities.Equipment;
import com.bao.shadowhunter.entities.PlayerCard;
import discord4j.core.object.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
public class Game {

    int id;

    @Getter
    HashMap<User, PlayerCard> players = new HashMap<>();

    List<Equipment> equipmentList;

    public void addPlayer(User user) {
        this.players.put(user, null);
    }

    public void initPlayerCards(List<User> users) {



    }



}
