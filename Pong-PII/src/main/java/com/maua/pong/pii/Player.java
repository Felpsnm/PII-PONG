package com.maua.pong.pii;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {

    private boolean right, left;
    private int x, y;
    private final int width, height;
    private final double speed;
    public Rectangle limites;
    private final Color color;
    private final int tipo;

    public Player(int x, int y, int tipo, Color color) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 5;
        this.speed = 1;
        this.color = color;
        this.tipo = tipo;
        colisaoPlayer();
    }

    //Getters
    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getSpeed() {
        return speed;
    }

    public Rectangle getLimites() {
        return limites;
    }

    public int getTipo() {
        return tipo;
    }
    
    

    //Setters
    public void setRight(boolean right) {
        this.right = right;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLimites(Rectangle limites) {
        this.limites = limites;
    }

    //Métodos
    private void colisaoPlayer() {
        setLimites(new Rectangle(getX(), getY(), getWidth(), getHeight()));
    }

    private void movimentoPlayer() {
        if (getTipo() == 1){
            setX((int)(getX() + ((Game.obterPosicaoBola() - getX() - 6) * 0.07)));
        } else {
            if (isRight()) {
                setX((int) (getX() + getSpeed()));
            } else if (isLeft()) {
                setX((int) (getX() - getSpeed()));
            }
        }
        if (getX() + getWidth() > Game.getGameWidth()) {
            setX(Game.getGameWidth() - getWidth());
        } else if (getX() < 0) {
            setX(0);
        }
    }

    private void renderizacaoPlayer(Graphics g) {
        g.setColor(color);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void tick() {
        movimentoPlayer();
        colisaoPlayer();
    }

    public void render(Graphics g) {
        renderizacaoPlayer(g);
    }
}
