package com.bao.shadowhunter.entities.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ZoneDescription {

    ZONE2(2, "Vous pouvez prendre la première carte de la pioche cartes Vision. Lisez ce qui est écrit dessus puis donnez-la à un autre joueur de votre choix"),
    ZONE3(3, "Vous pouvez prendre la première carte de la pioche cartes Vision. Lisez ce qui est écrit dessus puis donnez-la à un autre joueur de votre choix"),
    ZONE4(4, "Vous pouvez prendre la première carte d’une des trois pioches (Lumière, Ténèbres ou Vision). Suivez ses instructions."),
    ZONE5(5, "Vous pouvez prendre la première carte d’une des trois pioches (Lumière, Ténèbres ou Vision). Suivez ses instructions."),
    ZONE6(6, "Vous pouvez prendre la première carte de la pioche cartes Lumière. Suivez ses instructions.)"),
    ZONE8(8, "Vous pouvez prendre la première carte de la pioche cartes Ténèbres. Suivez ses instructions.)"),
    ZONE9(9, "Vous pouvez choisir un joueur (qui peut être vous) n’importe où sur le pla- teau et : lui infliger 2 Blessures OU lui soigner 1 Blessure.)"),
    ZONE10(10, "Vous pouvez voler une carte équipement au joueur de votre choix. (Rien ne se produit si aucun joueur n’a de carte équipement.");



    final int id;
    final String description;

}
