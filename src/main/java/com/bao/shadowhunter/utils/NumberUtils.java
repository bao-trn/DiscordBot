package com.bao.shadowhunter.utils;

import com.bao.shadowhunter.game.Game;

public class NumberUtils {

    public static void splitTeams(Game game, int nbPlayers) {
        int quotient = nbPlayers / 3;
        int remainder = nbPlayers % 3;
        game.setNbOpposingTeams(quotient);
        if (remainder == 0) {
            game.setNbNeutral(quotient);
        } else {
            game.setNbNeutral(quotient + remainder);
        }
    }

}
