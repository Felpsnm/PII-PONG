package com.maua.pong.pii;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

    public boolean right, left;
    public int x, y;
    public int width, height;
    private final double speed = 1;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 5;
    }

    private void movimentoPlayer() {
        if (right) {
            x += speed;
        } else if (left) {
            x -= speed;
        }
        if (x + width > Game.gameWidth) {
            x = Game.gameWidth - width;
        } else if (x < 0) {
            x = 0;
        }
    }

    private void renderizacaoPlayer(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(x, y, width, height);
    }

    public void tick() {
        movimentoPlayer();
    }

    public void render(Graphics g) {
        renderizacaoPlayer(g);
    }
}
