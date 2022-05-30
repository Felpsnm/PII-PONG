package com.maua.pong.pii;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

    private boolean right, left;
    private int x, y;
    private int width, height;
    private final double speed;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 5;
        this.speed = 1;
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

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    //Métodos
    private void movimentoPlayer() {
        if (isRight()) {
            setX((int)(getX() + getSpeed()));
        } else if (isLeft()) {
            setX((int)(getX() - getSpeed()));
        }
        
        if (getX() + getWidth() > Game.getGameWidth()) {
            setX(Game.getGameWidth() - getWidth());
        } else if (getX() < 0) {
            setX(0);
        }
    }

    private void renderizacaoPlayer(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void tick() {
        movimentoPlayer();
    }

    public void render(Graphics g) {
        renderizacaoPlayer(g);
    }
}
