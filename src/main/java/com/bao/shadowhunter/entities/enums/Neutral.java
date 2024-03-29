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
public enum Neutral {

    ALLIE(new PlayerCard(ShadowHunterConstants.TEAM_GREEN_THUMBNAIL, ShadowHunterConstants.TEAM_GREEN, "Allie", "Etre en vie lorsque la partie est finie", "Soignez toutes vos blessures", 8, "https://i.imgur.com/NHiOK8r.jpeg")),
    BOB(new PlayerCard(ShadowHunterConstants.TEAM_GREEN_THUMBNAIL, ShadowHunterConstants.TEAM_GREEN, "Bob", "Posséder 5 cartes équipements ou plus", "Si vous infligez 2HP ou plus de dégats à un joueur vous pouvez lui voler une carte équipement à la place", 10, "https://i.imgur.com/THQWNjh.jpeg")),
    CHARLES(new PlayerCard(ShadowHunterConstants.TEAM_GREEN_THUMBNAIL, ShadowHunterConstants.TEAM_GREEN, "Charles", "Tuer un personnage alors que 3 personnages ou plus sont morts", "Peut attaquer une deuxième fois en payant 2 HP", 11, "https://i.imgur.com/pzXJj0R.jpeg")),
    DANIEL(new PlayerCard(ShadowHunterConstants.TEAM_GREEN_THUMBNAIL, ShadowHunterConstants.TEAM_GREEN, "Daniel", "Mourir en premier ou être en vie quand tous les shadows sont morts", "Quand un joueur meurt, révélez votre carte", 13, "https://i.imgur.com/qBqEbsX.jpeg"));


    final PlayerCard playerCard;

    public static List<PlayerCard> getPlayerCards() {
        return Arrays.stream(Neutral.values())
                .map(Neutral::getPlayerCard)
                .collect(Collectors.toList());
    }
}

