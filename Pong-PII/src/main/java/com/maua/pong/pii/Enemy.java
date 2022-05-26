package com.maua.pong.pii;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {

    public boolean right, left;
    public double x, y;
    public int width, height;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 5;
    }

    private void enemyMovement() {
        x += (Game.ball.x - x - 6) * 0.07;

        if (right) {
            x++;
        } else if (left) {
            x--;
        }

        if (x + width > Game.gameWidth) {
            x = Game.gameWidth - width;
        } else if (x < 0) {
            x = 0;
        }
    }

    private void renderizacaoEnemy(Graphics g) {
        g.setColor(Color.magenta);
        g.fillRect((int) x, (int) y, width, height);
    }

    public void tick() {
        enemyMovement();
    }

    public void render(Graphics g) {
        renderizacaoEnemy(g);
    }
}
