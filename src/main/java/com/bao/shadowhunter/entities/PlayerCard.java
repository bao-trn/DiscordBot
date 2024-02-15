package com.bao.shadowhunter.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class PlayerCard {

    final String teamThumbnail;
    final String team;
    final String name;
    final String winCondition;
    final String ability;
    final int startingHp;
    final String cardImageURL;

    List<Equipment> equipped;


}
