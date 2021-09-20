package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Board extends JFrame implements ActionListener {

    // Player options
    private JButton buttonRock;
    private JButton buttonPaper;
    private JButton buttonScissors;
    private JButton buttonLizard;
    private JButton buttonSpock;

    // Board options
    private JButton buttonNewGame;
    private JButton buttonShowScoreboard;
    private JButton buttonExit;

    // Controllers
    Timer showResult = new Timer(800, this);

    private final GameMaster master = new GameMaster();
    private final ComputerIA ia = new ComputerIA();
    private final GameCanvas canvas = new GameCanvas();

    public Board() {
        super("Let's Play a Game!!");

        initComponents();
        setBounds(10, 10, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    private void initComponents() {
        JPanel boardOptions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel playerOptions = new JPanel(new FlowLayout());

        // Player options config
        buttonRock = new JButton("Piedra");
        buttonRock.setEnabled(false);
        buttonRock.addActionListener(this);

        buttonPaper = new JButton("Papel");
        buttonPaper.setEnabled(false);
        buttonPaper.addActionListener(this);

        buttonScissors = new JButton("Tijeras");
        buttonScissors.setEnabled(false);
        buttonScissors.addActionListener(this);

        buttonLizard = new JButton("Lagarto");
        buttonLizard.setEnabled(false);
        buttonLizard.addActionListener(this);

        buttonSpock = new JButton("Spock");
        buttonSpock.setEnabled(false);
        buttonSpock.addActionListener(this);

        // Board options config
        buttonNewGame = new JButton("Nuevo Juego");
        buttonNewGame.addActionListener(this);

        buttonShowScoreboard = new JButton("Puntuación");
        buttonShowScoreboard.addActionListener(this);

        buttonExit = new JButton("Salir");
        buttonExit.addActionListener(this);

        // Putting components in place
        boardOptions.add(buttonNewGame);
        boardOptions.add(buttonShowScoreboard);
        boardOptions.add(buttonExit);
        add(boardOptions, BorderLayout.NORTH);

        playerOptions.add(buttonRock);
        playerOptions.add(buttonPaper);
        playerOptions.add(buttonScissors);
        playerOptions.add(buttonLizard);
        playerOptions.add(buttonSpock);
        add(playerOptions, BorderLayout.SOUTH);

        add(new JLabel("Here goes The Canvas"), BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent clicked) {
        int playerChoice;
        if(clicked.getSource() == buttonExit) {
            System.exit(0);
        } else if(clicked.getSource() == buttonNewGame) {
            ia.makeChoice(master.getGames());
            buttonRock.setEnabled(true);
            buttonPaper.setEnabled(true);
            buttonScissors.setEnabled(true);
            buttonLizard.setEnabled(true);
            buttonSpock.setEnabled(true);
            buttonNewGame.setEnabled(false);
            canvas.clear();
        } else if(clicked.getSource() == buttonShowScoreboard) {
            JOptionPane.showMessageDialog(
                this,
                master.toString(),
                "Puntuación",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
        else if(clicked.getSource() == buttonRock) { play(GameMaster.ROCK); }
        else if(clicked.getSource() == buttonPaper) { play(GameMaster.PAPER); }
        else if(clicked.getSource() == buttonScissors) { play(GameMaster.SCISSORS); }
        else if(clicked.getSource() == buttonLizard) { play(GameMaster.LIZARD); }
        else if(clicked.getSource() == buttonSpock) { play(GameMaster.SPOCK); }
        else {
            canvas.showResult(master.getGameResult());
            buttonRock.setEnabled(false);
            buttonPaper.setEnabled(false);
            buttonScissors.setEnabled(false);
            buttonLizard.setEnabled(false);
            buttonSpock.setEnabled(false);
            buttonNewGame.setEnabled(true);
            showResult.stop();
        }
    }

    private void play(int playerChoice) {
        GameMaster.playerWins(ia.getComputerChoice(), playerChoice, master);
        canvas.showHands(playerChoice, ia.getComputerChoice());
        showResult.start();
        ia.updateRoulette(playerChoice);
    }
}
