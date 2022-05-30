package com.maua.pong.pii;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension; //https://docs.oracle.com/javase/7/docs/api/java/awt/Dimension.html
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable, KeyListener {

    private static int gameWidth, gameHeight, gameScale, gameWidthStaggered, gameHeightStaggered;
    private int pontosPlayer;
    private int pontosPlayer2orEnemy;
    private static String gameState = "MENU";;

    private static Player player;
    private static Player2 player2;
    private static Enemy enemy;
    private static Ball ball;
    private static Menu menu;
    private static Quiz quiz;
    private static BufferedImage layer;

    //Construtor 
    public Game() {
        //Tamanhos do Game
        gameWidth = 160;
        gameHeight = 120;
        gameScale = 3;
        gameWidthStaggered = gameWidth * gameScale;
        gameHeightStaggered = gameHeight * gameScale;

        //Definindo Variáveis do Jogo
        pontosPlayer = 0;
        pontosPlayer2orEnemy = 0;

        setPreferredSize(new Dimension(gameWidthStaggered, gameHeightStaggered));
        addKeyListener(this);

        //Instanciando objetos
        layer = new BufferedImage(gameWidth, gameHeight, BufferedImage.TYPE_INT_RGB);
        player = new Player(100, gameHeight - 5);
        player2 = new Player2(100, 0);
        enemy = new Enemy(100, 0);
        ball = new Ball(100, gameHeight / 2 - 1);
        menu = new Menu();
        quiz = new Quiz();
    }

    //Setters
    public void setPontosPlayer(int pontosPlayer) {
        this.pontosPlayer = pontosPlayer;
    }

    public void setPontosPlayer2orEnemy(int pontosPlayer2orEnemy) {
        this.pontosPlayer2orEnemy = pontosPlayer2orEnemy;
    }

    public static void setGameState(String gameState) {
        Game.gameState = gameState;
    }

    //Getters
    public int getPontosPlayer() {
        return pontosPlayer;
    }

    public int getPontosPlayer2orEnemy() {
        return pontosPlayer2orEnemy;
    }

    public String getGameState() {
        return gameState;
    }

    public static int getGameWidth() {
        return gameWidth;
    }

    public static int getGameHeight() {
        return gameHeight;
    }

    public static int getGameWidthStaggered() {
        return gameWidthStaggered;
    }

    public static int getGameHeightStaggered() {
        return gameHeightStaggered;
    }

    public static Player getPlayer() {
        return player;
    }

    public static Player2 getPlayer2() {
        return player2;
    }

    public static Enemy getEnemy() {
        return enemy;
    }

    public static Ball getBall() {
        return ball;
    }

    public static Menu getMenu() {
        return menu;
    }

    public static Quiz getQuiz() {
        return quiz;
    }

    //Métodos
    //Verificação dos gols
    private void verificarGol() {
        if (ball.getY() >= getGameHeight()) {
            setPontosPlayer2orEnemy(getPontosPlayer2orEnemy() + 1);
            Game.setGameState("QUIZ");
            quiz.setPlayer(true);
        } else if (ball.getY() < 0) {
            setPontosPlayer(getPontosPlayer() + 1);
            if (this.getGameState() == "COOP") {
                Game.setGameState("QUIZ");
                quiz.setPlayer2orEnemy(true);
            } else {
                Main.createGameInstance();
            }
        }
        System.out.println("Player 1: " + pontosPlayer + " Player 2: " + pontosPlayer2orEnemy);
    }

    //Execução dos Ticks
    private void execTicks() {
        if (null != gameState) {
            switch (gameState) {
                case "MENU" ->
                    menu.tick();
                case "SINGLEPLAYER" -> {
                    player.tick();
                    enemy.tick();
                    ball.tick();
                    verificarGol();
                }
                case "COOP" -> {
                    player.tick();
                    player2.tick();
                    ball.tick();
                    verificarGol();
                }
                case "QUIZ" ->
                    quiz.tick();
            }
        }
    }

    //Execução da renderização
    private void execRenders() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = layer.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, gameWidth, gameHeight);

        if (null != gameState) {
            switch (gameState) {
                case "MENU" ->
                    menu.render(g);
                case "SINGLEPLAYER" -> {
                    player.render(g);
                    enemy.render(g);
                    ball.render(g);
                }
                case "COOP" -> {
                    player.render(g);
                    player2.render(g);
                    ball.render(g);
                }
                case "QUIZ" ->
                    quiz.render(g);
            }
        }
        g = bs.getDrawGraphics();
        g.drawImage(layer, 0, 0, gameWidthStaggered, gameHeightStaggered, null);
        bs.show();
    }

    @Override
    public void run() {
        while (true) {
            execTicks();
            execRenders();
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> {
                menu.setUp(true);
            }
            case KeyEvent.VK_DOWN -> {
                menu.setDown(true);
            }
            case KeyEvent.VK_ENTER -> {
                menu.setEnter(true);
            }

            case KeyEvent.VK_RIGHT -> {
                player.setRight(true);
            }
            case KeyEvent.VK_LEFT -> {
                player.setLeft(true);
            }
            case KeyEvent.VK_D -> {
                player2.setRight(true);
            }
            case KeyEvent.VK_A -> {
                player2.setLeft(true);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            //Player 1
            case KeyEvent.VK_RIGHT -> {
                player.setRight(false);
            }
            case KeyEvent.VK_LEFT -> {
                player.setLeft(false);
            }

            //Player 2
            case KeyEvent.VK_D -> {
                player2.setRight(false);
            }
            case KeyEvent.VK_A -> {
                player2.setLeft(false);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }
}
