package com.maua.pong.pii;

import java.awt.Color;
import java.awt.Graphics;

public class Player2 {

    public boolean right, left;
    public double x, y;
    public int width, height;

    public Player2(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 5;
    }

    private void player2Movement() {
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

    private void renderizacaoPlayer2(Graphics g) {
        g.setColor(Color.magenta);
        g.fillRect((int) x, (int) y, width, height);
    }

    public void tick() {
        player2Movement();
    }

    public void render(Graphics g) {
        renderizacaoPlayer2(g);
    }
}
