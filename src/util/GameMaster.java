package util;

public class GameMaster {
    // Options id
    public final static int ROCK = 1;
    public final static int PAPER = 2;
    public final static int SCISSORS = 3;
    public final static int LIZARD = 4;
    public final static int SPOCK = 5;

    private int wins = 0;
    private int loses = 0;
    private int draws = 0;
    private int gameResult = 0;

    public static void playerWins(int computerChoice, int playerChoice, GameMaster master) {
        int gameResult = 0;
        switch(playerChoice) {
            case ROCK:
                switch(computerChoice) {
                    case PAPER:
                        master.loses++;
                        gameResult = -1;
                    break;

                    case SCISSORS:
                        master.wins++;
                        gameResult = 1;
                    break;

                    case LIZARD:
                        master.wins++;
                        gameResult = 1;
                    break;

                    case SPOCK:
                        master.loses++;
                        gameResult = -1;
                    break;

                    default:
                        master.draws++;
                }
            break;

            case PAPER:
                switch(computerChoice) {
                    case ROCK:
                        master.wins++;
                        gameResult = 1;
                    break;

                    case SCISSORS:
                        master.loses++;
                        gameResult = -1;
                    break;

                    case LIZARD:
                        master.loses++;
                        gameResult = -1;
                    break;

                    case SPOCK:
                        master.wins++;
                        gameResult = 1;
                    break;

                    default:
                        master.draws++;
                }
            break;

            case SCISSORS:
                switch(computerChoice) {
                    case ROCK:
                        master.loses++;
                        gameResult = -1;
                    break;

                    case PAPER:
                        master.wins++;
                        gameResult = 1;
                    break;

                    case LIZARD:
                        master.wins++;
                        gameResult = 1;
                    break;

                    case SPOCK:
                        master.loses++;
                        gameResult = -1;
                    break;

                    default:
                        master.draws++;
                }
            break;

            case LIZARD:
                switch(computerChoice) {
                    case ROCK:
                        master.loses++;
                        gameResult = -1;
                    break;

                    case PAPER:
                        master.wins++;
                        gameResult = 1;
                    break;

                    case SCISSORS:
                        master.loses++;
                        gameResult = -1;
                    break;

                    case SPOCK:
                        master.wins++;
                        gameResult = 1;
                    break;

                    default:
                        master.draws++;
                }
            break;

            case SPOCK:
                switch(computerChoice) {
                    case ROCK:
                        master.wins++;
                        gameResult = 1;
                    break;

                    case PAPER:
                        master.loses++;
                        gameResult = -1;
                    break;

                    case SCISSORS:
                        master.wins++;
                        gameResult = 1;
                    break;

                    case LIZARD:
                        master.loses++;
                        gameResult = -1;
                    break;

                    default:
                        master.draws++;
                }
            break;
        }
        master.gameResult = gameResult;
    }

    public int getGames() { return wins + loses + draws; }

    public int getGameResult() { return gameResult; }

    @Override
    public String toString() {
        return "Juegos: " + getGames() + " | ganados: " + wins + " | perdidos: " + loses + " | empatados: " + draws;
    }
}
