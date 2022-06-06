package com.maua.pong.pii;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension; //https://docs.oracle.com/javase/7/docs/api/java/awt/Dimension.html
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game extends Canvas implements Runnable, KeyListener {

    private static int gameWidth, gameHeight, gameScale, gameWidthStaggered, gameHeightStaggered;
    private static int pontosPlayer;
    private static int pontosPlayer2;
    private static String gameState = "LOGIN";
    private static int freezeGame = 0;

    private static Player player, player2, enemy;
    private static Ball ball;
    private static LoginTela loginTela;
    private static Menu menu;
    private static Quiz quiz;
    private static BufferedImage layer;

    //Construtor 
    public Game(int pontosPlayer, int pontosPlayer2) {
        //Tamanhos do Game
        gameWidth = 160;
        gameHeight = 120;
        gameScale = 3;
        gameWidthStaggered = gameWidth * gameScale;
        gameHeightStaggered = gameHeight * gameScale;

        //Definindo Variáveis do Jogo
        pontosPlayer = 0;
        pontosPlayer2 = 0;

        setPreferredSize(new Dimension(gameWidthStaggered, gameHeightStaggered));
        addKeyListener(this);

        //Instanciando objetos
        layer = new BufferedImage(gameWidth, gameHeight, BufferedImage.TYPE_INT_RGB);
        loginTela = new LoginTela();
        menu = new Menu();
        ball = new Ball(100, gameHeight / 2 - 1);
        player = new Player(100, gameHeight - 5, 0, Color.blue);
        player2 = new Player(100, 0, 0, Color.yellow);
        enemy = new Player(100, 0, 1, Color.red);
        quiz = new Quiz();
    }

    //Setters
    public static void setPontosPlayer(int pontosPlayer) {
        Game.pontosPlayer = pontosPlayer;
    }

    public static void setPontosPlayer2(int pontosPlayer2) {
        Game.pontosPlayer2 = pontosPlayer2;
    }

    public static void setGameState(String gameState) {
        Game.gameState = gameState;
    }

    public static void setFreezeGame(int freezeGame) {
        Game.freezeGame = freezeGame;
    }

    //Getters
    public static int getPontosPlayer() {
        return pontosPlayer;
    }

    public static int getPontosPlayer2() {
        return pontosPlayer2;
    }

    public static String getGameState() {
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

    public static int getFreezeGame() {
        return freezeGame;
    }

//------------Métodos
    //Verificação das colisões
    private void verificarColisao() {
        //Colisão lateral
        if (ball.getX() + (ball.getDx() * ball.getSpeed()) + ball.getSpeed() >= getGameWidth() || ball.getX() + (ball.getDx() * ball.getSpeed()) < 0) {
            ball.setDx(ball.getDx() * -1);
        }

        //Colisões Gerais
        if (ball.getLimites().intersects(player.getLimites())) {
            ball.setAngle(new Random().nextInt(120 - 45) + 46);
            ball.setDx(Math.cos(Math.toRadians(ball.getAngle())));
            ball.setDy(Math.sin(Math.toRadians(ball.getAngle())));
            if (ball.getDy() > 0) {
                ball.setDy(ball.getDy() * -1);
            }
        }
        if (ball.getLimites().intersects(enemy.getLimites()) || ball.getLimites().intersects(player2.getLimites())) {
            ball.setAngle(new Random().nextInt(120 - 45) + 46);
            ball.setDx(Math.cos(Math.toRadians(ball.getAngle())));
            ball.setDy(Math.sin(Math.toRadians(ball.getAngle())));
            if (ball.getDy() < 0) {
                ball.setDy(ball.getDy() * -1);
            }
        }
    }

    //Verificação dos gols
    private void verificarGol() {
        if (ball.getY() >= getGameHeight()) {
            adicionarPontoPlayer2();
            Main.createGameInstance(pontosPlayer, pontosPlayer2);
            setFreezeGame(1);
            quiz.renderizacaoQuiz();
            quiz.setPlayer(true);
        } else if (ball.getY() < 0) {
            adicionarPontoPlayer();
            Main.createGameInstance(pontosPlayer, pontosPlayer2);
            setFreezeGame(1);
            quiz.renderizacaoQuiz();
            if (getGameState() == "COOP") {
                quiz.setPlayer2(true);
            }
        }
    }

    //Adicionar ponto Player
    public static void adicionarPontoPlayer() {
        setPontosPlayer(Game.getPontosPlayer() + 1);
    }

    //Adicionar ponto Player2
    public static void adicionarPontoPlayer2() {
        setPontosPlayer2(getPontosPlayer2() + 1);
    }

    //Obtendo posição atual da bola
    public static double obterPosicaoBola() {
        return ball.getX();
    }

    //Execução dos Ticks
    private void execTicks() {
        if (getFreezeGame() == 0) {
            switch (getGameState()) {
                case "CLOSE" -> {
                    System.exit(0);
                }
                case "LOGIN" -> {
                    loginTela.setVisible(true);
                }
                case "MENU" -> {
                    menu.tick();
                    break;
                }
                case "SINGLEPLAYER" -> {
                    player.tick();
                    enemy.tick();
                    ball.tick();
                }
                case "COOP" -> {
                    player.tick();
                    player2.tick();
                    ball.tick();
                }
            }
            verificarColisao();
            verificarGol();
        }
    }

    //Execução da renderização
    private void execRenders() {
        if (getFreezeGame() == 0) {
            BufferStrategy bs = this.getBufferStrategy();
            if (bs == null) {
                this.createBufferStrategy(3);
                return;
            }
            Graphics g = layer.getGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, getGameWidth(), getGameHeight());

            switch (getGameState()) {
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
            }
            g = bs.getDrawGraphics();
            g.drawImage(layer, 0, 0, getGameWidthStaggered(), getGameHeightStaggered(), null);
            bs.show();
        }
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
