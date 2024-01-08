package com.bao.shadowhunter.entities;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Light {

    EFFECT1("reduce damage taken by 1"),
    EFFECT2("heal 1 damage"),
    EFFECT3("deal 2 more damage");

    final String description;

}
