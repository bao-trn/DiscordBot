package com.bao.shadowhunter.entities;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PlayerCard {

    final String team;
    final String name;
    final String winCondition;
    final String ability;
    int hp;

    List<Equipment> equipped;


}
