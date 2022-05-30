package com.maua.pong.pii;

import java.awt.Color;
import java.awt.Graphics;

public class Player2 {

    private boolean right, left;
    private double x, y;
    private int width, height;

    public Player2(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 5;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    private void player2Movement() {
        if (isRight()) {
            setX(getX() + 1);
        } else if (isLeft()) {
            setX(getX() - 1);
        }
        if (getX() + getWidth() > Game.getGameWidth()) {
            setX(Game.getGameWidth() - getWidth());
        } else if (getX() < 0) {
            setX(0);
        }
    }

    private void renderizacaoPlayer2(Graphics g) {
        g.setColor(Color.magenta);
        g.fillRect((int) getX(), (int) getY(), getWidth(), getHeight());
    }

    public void tick() {
        player2Movement();
    }

    public void render(Graphics g) {
        renderizacaoPlayer2(g);
    }
}
