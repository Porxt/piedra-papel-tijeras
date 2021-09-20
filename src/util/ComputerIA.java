package util;

import java.util.HashMap;

public class ComputerIA {
    private final int[] roulette = {
        1, 1, 1, 1,
        2, 2, 2, 2,
        3, 3, 3, 3,
        4, 4, 4, 4,
        5, 5, 5, 5
    };
    private final HashMap<Integer, Integer> probability;
    private int computerChoice;

    public ComputerIA() {
        probability = new HashMap<>();
        probability.put(GameMaster.ROCK, 4);
        probability.put(GameMaster.PAPER, 4);
        probability.put(GameMaster.SCISSORS, 4);
        probability.put(GameMaster.LIZARD, 4);
        probability.put(GameMaster.SPOCK, 4);
    }

    public void makeChoice(int games) {
        if(games <= 5) {
            computerChoice = (int) (Math.random() * 5 + 1);
        } else {
            computerChoice = (int) (Math.random() * 20);
            computerChoice = roulette[computerChoice];
        }
    }

    public int getComputerChoice() {
        return computerChoice;
    }

    public void updateRoulette(int playerOption) {
        int index = 0;
        switch(playerOption) {
            case GameMaster.ROCK:
                if(probability.get(playerOption) > 1) {
                    probability.put(playerOption, probability.get(playerOption) - 1);
                    if(probability.get(GameMaster.PAPER) <= probability.get(GameMaster.SPOCK)) {
                        probability.put(GameMaster.PAPER, probability.get(GameMaster.PAPER) + 1);
                    } else {
                        probability.put(GameMaster.SPOCK, probability.get(GameMaster.SPOCK) + 1);
                    }
                }
            break;

            case GameMaster.PAPER:
                if(probability.get(playerOption) > 1) {
                    probability.put(playerOption, probability.get(playerOption) - 1);
                    if(probability.get(GameMaster.SCISSORS) <= probability.get(GameMaster.LIZARD)) {
                        probability.put(GameMaster.SCISSORS, probability.get(GameMaster.SCISSORS) + 1);
                    } else {
                        probability.put(GameMaster.LIZARD, probability.get(GameMaster.LIZARD) + 1);
                    }
                }
            break;

            case GameMaster.SCISSORS:
                if(probability.get(playerOption) > 1) {
                    probability.put(playerOption, probability.get(playerOption) - 1);
                    if(probability.get(GameMaster.ROCK) <= probability.get(GameMaster.SPOCK)) {
                        probability.put(GameMaster.ROCK, probability.get(GameMaster.ROCK) + 1);
                    } else {
                        probability.put(GameMaster.SPOCK, probability.get(GameMaster.SPOCK) + 1);
                    }
                }
            break;

            case GameMaster.LIZARD:
                if(probability.get(playerOption) > 1) {
                    probability.put(playerOption, probability.get(playerOption) - 1);
                    if(probability.get(GameMaster.SCISSORS) <= probability.get(GameMaster.ROCK)) {
                        probability.put(GameMaster.SCISSORS, probability.get(GameMaster.SCISSORS) + 1);
                    } else {
                        probability.put(GameMaster.ROCK, probability.get(GameMaster.ROCK) + 1);
                    }
                }
            break;

            case GameMaster.SPOCK:
                if(probability.get(playerOption) > 1) {
                    probability.put(playerOption, probability.get(playerOption) - 1);
                    if(probability.get(GameMaster.PAPER) <= probability.get(GameMaster.LIZARD)) {
                        probability.put(GameMaster.PAPER, probability.get(GameMaster.PAPER) + 1);
                    } else {
                        probability.put(GameMaster.LIZARD, probability.get(GameMaster.LIZARD) + 1);
                    }
                }
            break;
        }

        for(int key : probability.keySet()) {
            for(int i = 0; i < probability.get(key); i++, index++) {
                roulette[index] = key;
            }
        }
    }
}
