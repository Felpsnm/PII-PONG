package com.maua.pong.pii;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {

    public double x, y, dx, dy, speed;
    public int width, height;
    public int angle;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 4;
        this.height = 4;
        speed = 1.7;
        angle = new Random().nextInt(120 - 45);
        dx = Math.cos(Math.toRadians(angle));
        dy = Math.sin(Math.toRadians(angle));
    }

    private void colisaoBola() {
        //Colisão lateral
        if (x + (dx * speed) + width >= Game.gameWidth || x + (dx * speed) < 0) {
            dx *= -1;
        }

        //Colisão objetos
        Rectangle bounds = new Rectangle((int) (x + (dx * speed)), (int) (y + (dy * speed)), width, height);
        Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
        Rectangle boundsPlayer2 = new Rectangle((int) Game.player2.x, (int) Game.player2.y, Game.player2.width, Game.player2.height);
        Rectangle boundsEnemy = new Rectangle((int) Game.enemy.x, (int) Game.enemy.y, Game.enemy.width, Game.enemy.height);

        if (bounds.intersects(boundsPlayer)) {
            angle = new Random().nextInt(120 - 45) + 46;
            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));
            if (dy > 0) {
                dy *= -1;
            }
        }
        if (Game.gameState == "SINGLEPLAYER") {
            if (bounds.intersects(boundsEnemy)) {
                angle = new Random().nextInt(120 - 45) + 46;
                dx = Math.cos(Math.toRadians(angle));
                dy = Math.sin(Math.toRadians(angle));
                if (dy < 0) {
                    dy *= -1;
                }
            }
        } else if (Game.gameState == "COOP") {
            if (bounds.intersects(boundsPlayer2)) {
                angle = new Random().nextInt(120 - 45) + 46;
                dx = Math.cos(Math.toRadians(angle));
                dy = Math.sin(Math.toRadians(angle));
                if (dy < 0) {
                    dy *= -1;
                }
            }
        }
    }

    private void movimentoBola() {
        x += dx * speed;
        y += dy * speed;
    }

    private void renderizacaoBola(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int) x, (int) y, width, height);
    }

    public void tick() {
        colisaoBola();
        movimentoBola();
    }

    public void render(Graphics g) {
        renderizacaoBola(g);
    }

}
