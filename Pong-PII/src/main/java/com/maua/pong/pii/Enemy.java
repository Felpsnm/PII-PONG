package com.maua.pong.pii;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {

    private boolean right, left;
    private double x, y;
    private int width, height;
    
    //Construtor
    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 5;
    }
    
    //Getters
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
    
    //Setters
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
    
    //Métodos
    private void enemyMovement() {
        setX(getX() + ((Game.getBall().getX() - getX() - 6) * 0.07));

        if (isRight())
            setX(getX() + 1);
        else if (isLeft())
            setX(getX() - 1);

        if (getX() + getWidth() > Game.getGameWidth())
            setX(Game.getGameWidth() - getWidth());
        else if (getX() < 0)
            setX(0);
    }

    private void renderizacaoEnemy(Graphics g) {
        g.setColor(Color.magenta);
        g.fillRect((int) getX(), (int) getY(), getWidth(), getHeight());
    }

    public void tick() {
        enemyMovement();
    }

    public void render(Graphics g) {
        renderizacaoEnemy(g);
    }
}
