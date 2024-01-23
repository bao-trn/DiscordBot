package com.bao.shadowhunter.entities;

import com.bao.shadowhunter.constants.ShadowHunterConstants;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum Hunter {

    EMI(new PlayerCard(ShadowHunterConstants.TEAM_BLUE, "Emi", ShadowHunterConstants.TEAM_BLUE_WIN_CONDITION, ShadowHunterConstants.EMI_ABILITY, 10)),
    FRANKLIN(new PlayerCard(ShadowHunterConstants.TEAM_BLUE, "Franklin", ShadowHunterConstants.TEAM_BLUE_WIN_CONDITION, ShadowHunterConstants.FRANKLIN_ABILITY, 12)),
    GEORGES(new PlayerCard(ShadowHunterConstants.TEAM_BLUE, "Georges", ShadowHunterConstants.TEAM_BLUE_WIN_CONDITION, ShadowHunterConstants.GEORGES_ABILITY, 14));

    final PlayerCard playerCard;

    public static List<PlayerCard> getPlayerCards() {
        return Arrays.stream(Hunter.values())
                .map(Hunter::getPlayerCard)
                .collect(Collectors.toList());
    }
}
