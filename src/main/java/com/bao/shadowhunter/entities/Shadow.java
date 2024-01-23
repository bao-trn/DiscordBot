package com.bao.shadowhunter.entities;

import com.bao.shadowhunter.constants.ShadowHunterConstants;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum Shadow {

    WEREWOLF(new PlayerCard(ShadowHunterConstants.TEAM_RED, "Loup-Garou", ShadowHunterConstants.TEAM_RED_WIN_CONDITION, ShadowHunterConstants.WEREWOLF_ABILITY, 13)),
    METAMORPH(new PlayerCard(ShadowHunterConstants.TEAM_RED, "Bob", ShadowHunterConstants.TEAM_RED_WIN_CONDITION, ShadowHunterConstants.METAMORPH_ABILITY, 11)),
    VAMPIRE(new PlayerCard(ShadowHunterConstants.TEAM_RED, "Charles", ShadowHunterConstants.TEAM_RED_WIN_CONDITION, ShadowHunterConstants.VAMPIRE_ABILITY, 13));


    final PlayerCard playerCard;

    public static List<PlayerCard> getPlayerCards() {
        return Arrays.stream(Shadow.values())
                .map(Shadow::getPlayerCard)
                .collect(Collectors.toList());
    }

}
