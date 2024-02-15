package com.bao.shadowhunter.entities.enums;

import com.bao.shadowhunter.constants.ShadowHunterConstants;
import com.bao.shadowhunter.entities.PlayerCard;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum Hunter {

    EMI(new PlayerCard(ShadowHunterConstants.TEAM_BLUE_THUMBNAIL, ShadowHunterConstants.TEAM_BLUE, "Emi", ShadowHunterConstants.TEAM_BLUE_WIN_CONDITION, ShadowHunterConstants.EMI_ABILITY, 10, "https://i.imgur.com/nnGtOtb.jpeg")),
    FRANKLIN(new PlayerCard(ShadowHunterConstants.TEAM_BLUE_THUMBNAIL, ShadowHunterConstants.TEAM_BLUE, "Franklin", ShadowHunterConstants.TEAM_BLUE_WIN_CONDITION, ShadowHunterConstants.FRANKLIN_ABILITY, 12, "https://i.imgur.com/pvyjD5d.jpeg")),
    GEORGES(new PlayerCard(ShadowHunterConstants.TEAM_BLUE_THUMBNAIL, ShadowHunterConstants.TEAM_BLUE, "Georges", ShadowHunterConstants.TEAM_BLUE_WIN_CONDITION, ShadowHunterConstants.GEORGES_ABILITY, 14, "https://i.imgur.com/8X2pHxa.jpeg"));

    final PlayerCard playerCard;

    public static List<PlayerCard> getPlayerCards() {
        return Arrays.stream(Hunter.values())
                .map(Hunter::getPlayerCard)
                .collect(Collectors.toList());
    }
}
