package com.maua.pong.pii;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {

    private double x, y, dx, dy;
    private final double speed;
    private final int width, height;
    private int angle;   
    private Rectangle limites;
    
    
    //Construtor
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 4;
        this.height = 4;
        this.speed = 1.7;
        this.angle = new Random().nextInt(120 - 45);
        this.dx = Math.cos(Math.toRadians(angle));
        this.dy = Math.sin(Math.toRadians(angle));
        colisaoBola();
    }
    
    //Getters
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public double getSpeed() {
        return speed;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getAngle() {
        return angle;
    }

    public Rectangle getLimites() {
        return limites;
    }
    
    //Setters  
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }
    
    public void setDy(double dy) {
        this.dy = dy;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
    
    public void setLimites(Rectangle limites) {
        this.limites = limites;
    }
    
    private void colisaoBola() {
        setLimites(new Rectangle((int) (getX() + (getDx() * getSpeed())), (int) (getY() + (getDy() * getSpeed())), getWidth(), getHeight()));
    }

    private void movimentoBola() {
        setX(getX() + (getDx() * getSpeed()));
        setY(getY() + (getDy() * getSpeed()));
    }

    private void renderizacaoBola(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int) getX(), (int) getY(), getWidth(), getHeight());
    }

    public void tick() {
        colisaoBola();
        movimentoBola();
    }

    public void render(Graphics g) {
        renderizacaoBola(g);
    }

}
