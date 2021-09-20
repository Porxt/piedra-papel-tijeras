package ui;

import util.GameMaster;

import java.awt.*;

public class GameCanvas extends Canvas {

    private final Toolkit getImageHelper;

    private int playerChoice;
    private int computerChoice;
    private int gameResult;

    public GameCanvas() {
        getImageHelper = Toolkit.getDefaultToolkit();
        playerChoice = 0;
        computerChoice = 0;
        gameResult = -2;
    }

    public void paint(Graphics g) {
        super.paint(g);

        Image imagePlayerOption;
        Image imageComputerOption;
        Image imageGameResult;

        switch(playerChoice) {
            case GameMaster.ROCK:
                imagePlayerOption = getImageHelper.getImage(getClass().getResource("images/piedra.png"));
                break;

            case GameMaster.PAPER:
                imagePlayerOption = getImageHelper.getImage(getClass().getResource("images/papel.png"));
                break;

            case GameMaster.SCISSORS:
                imagePlayerOption = getImageHelper.getImage(getClass().getResource("images/tijeras.png"));
                break;

            case GameMaster.LIZARD:
                imagePlayerOption = getImageHelper.getImage(getClass().getResource("images/lagarto.png"));
                break;

            case GameMaster.SPOCK:
                imagePlayerOption = getImageHelper.getImage(getClass().getResource("images/spock.png"));
                break;

            default:
                imagePlayerOption = null;
        }
        if(imagePlayerOption != null) { g.drawImage(imagePlayerOption, 200, 280, this); }

        switch(computerChoice) {
            case GameMaster.ROCK:
                imageComputerOption = getImageHelper.getImage(getClass().getResource("images/piedra_IA.png"));
                break;

            case GameMaster.PAPER:
                imageComputerOption = getImageHelper.getImage(getClass().getResource("images/papel_IA.png"));
                break;

            case GameMaster.SCISSORS:
                imageComputerOption = getImageHelper.getImage(getClass().getResource("images/tijeras_IA.png"));
                break;

            case GameMaster.LIZARD:
                imageComputerOption = getImageHelper.getImage(getClass().getResource("images/lagarto_IA.png"));
                break;

            case GameMaster.SPOCK:
                imageComputerOption = getImageHelper.getImage(getClass().getResource("images/spock_IA.png"));
                break;

            default:
                imageComputerOption = null;
        }
        if(imageComputerOption != null) { g.drawImage(imageComputerOption, 200, 10, this); }

        switch(gameResult) {
            case -1:
                imageGameResult = getImageHelper.getImage(getClass().getResource("images/lose.png"));
                g.drawImage(imageGameResult, 160, 115, 180, 150, this);
                break;

            case 0:
                imageGameResult = getImageHelper.getImage(getClass().getResource("images/draw.png"));
                g.drawImage(imageGameResult, 135, 150, 242, 102, this);
                break;

            case 1:
                imageGameResult = getImageHelper.getImage(getClass().getResource("images/win.png"));
                g.drawImage(imageGameResult, 135, 120, 255, 130, this);
                break;
        }
    }

    public void showHands(int playerChoice, int computerChoice) {
        this.playerChoice = playerChoice;
        this.computerChoice = computerChoice;
        repaint();
    }

    public void showResult(int gameResult) {
        this.gameResult = gameResult;
        repaint();
    }

    public void clear() {
        playerChoice = 0;
        computerChoice = 0;
        gameResult = -2;

        repaint();
    }
}
