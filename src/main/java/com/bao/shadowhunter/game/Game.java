package com.bao.shadowhunter.game;

import com.bao.shadowhunter.entities.*;
import com.bao.shadowhunter.utils.NumberUtils;
import discord4j.core.object.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class Game {

    int id;

    @Getter
    HashMap<User, PlayerCard> players = new HashMap<>();
    List<PlayerCard> neutrals = Neutral.getPlayerCards();
    List<PlayerCard> shadows = Shadow.getPlayerCards();
    List<PlayerCard> hunters = Hunter.getPlayerCards();

    @Setter
    int nbNeutral;
    @Setter
    int nbOpposingTeams;

    List<Equipment> equipmentList;

    public void addPlayer(User user) {
        this.players.put(user, null);
    }

    public void initPlayerCards() {
        NumberUtils.splitTeams(this, players.size());
        distributePlayerCards();
    }

    private void distributePlayerCards() {
        AtomicInteger nbShadows = new AtomicInteger();
        AtomicInteger nbHunters = new AtomicInteger();
        AtomicInteger nbNeutrals = new AtomicInteger();
        Random random = new Random();
        players.forEach((user, playerCard) -> {
            int randomList = random.nextInt(3);
            switch (randomList) {
                case 0:
                    if (nbShadows.get() <= nbOpposingTeams) {
                        int randomIndexShadow = random.nextInt(shadows.size());
                        players.put(user, shadows.get(randomIndexShadow));
                        shadows.remove(randomIndexShadow);
                        nbShadows.getAndIncrement();
                        break;
                    }
                case 1:
                    if (nbHunters.get() <= nbOpposingTeams) {
                        int randomIndexHunter = random.nextInt(hunters.size());
                        players.put(user, hunters.get(randomIndexHunter));
                        hunters.remove(randomIndexHunter);
                        nbHunters.getAndIncrement();
                        break;
                    }
                case 2:
                    if (nbNeutrals.get() <= nbNeutral) {
                        int randomIndexNeutral = random.nextInt(neutrals.size());
                        players.put(user, neutrals.get(randomIndexNeutral));
                        neutrals.remove(randomIndexNeutral);
                        nbNeutrals.getAndIncrement();
                        break;
                    }
                case 3: // fail-safe in case neutrals gets filled before other teams
                    if (nbShadows.get() <= nbOpposingTeams) {
                        int randomIndexShadow = random.nextInt(shadows.size());
                        players.put(user, shadows.get(randomIndexShadow));
                        shadows.remove(randomIndexShadow);
                        nbShadows.getAndIncrement();
                        break;
                    }
                default:
                    int randomIndexHunter = random.nextInt(hunters.size());
                    players.put(user, hunters.get(randomIndexHunter));
                    hunters.remove(randomIndexHunter);
                    nbHunters.getAndIncrement();

            }







        });
    }



}
