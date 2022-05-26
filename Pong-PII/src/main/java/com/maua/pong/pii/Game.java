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

    public static int gameWidth = 160, gameHeight = 120, gameScale = 3;
    public int pontosPlayer = 0;
    public int pontosPlayer2Enemy = 0;

    public static Player player;
    public static Player2 player2;
    public static Enemy enemy;
    public static Ball ball;
    private final Menu menu;
    public static Quiz quiz;

    private final BufferedImage layer;

    public static String gameState = "MENU";

    public Game() {
        this.setPreferredSize(new Dimension(gameWidth * gameScale, gameHeight * gameScale));
        this.addKeyListener(this);
        layer = new BufferedImage(gameWidth, gameHeight, BufferedImage.TYPE_INT_RGB);
        player = new Player(100, gameHeight - 5);
        player2 = new Player2(100, 0);
        enemy = new Enemy(100, 0);
        ball = new Ball(100, gameHeight / 2 - 1);
        menu = new Menu();
        quiz = new Quiz();
    }

    private void verificarGol() {
        if (ball.y >= gameHeight) {
            pontosPlayer2Enemy += 1;
            if (gameState == "COOP") {
                Game.gameState = "QUIZ";
                quiz.player = true;
            } else {
                new Game();
            }
        } else if (ball.y < 0) {
            pontosPlayer += 1;
            Game.gameState = "QUIZ";
            quiz.player2 = true;
        }
        System.out.println("Player 1: " + pontosPlayer + " Player 2: " + pontosPlayer2Enemy);
    }

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
                default -> {
                }
            }
        }
    }

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
                default -> {
                }
            }
        }
        g = bs.getDrawGraphics();
        g.drawImage(layer, 0, 0, gameWidth * gameScale, gameHeight * gameScale, null);
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
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            menu.up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            menu.down = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            menu.enter = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = true;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_D) {
            player2.right = true;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            player2.left = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_D) {
            player2.right = false;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            player2.left = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }
}
