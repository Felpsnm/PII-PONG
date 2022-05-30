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
    private Rectangle limitesPlayer;
    private Rectangle limitesPlayer2;
    private Rectangle limitesEnemy;
    
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

    public Rectangle getLimitesPlayer() {
        return limitesPlayer;
    }

    public Rectangle getLimitesPlayer2() {
        return limitesPlayer2;
    }

    public Rectangle getLimitesEnemy() {
        return limitesEnemy;
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

    public void setLimitesPlayer(Rectangle limitesPlayer) {
        this.limitesPlayer = limitesPlayer;
    }

    public void setLimitesPlayer2(Rectangle limitesPlayer2) {
        this.limitesPlayer2 = limitesPlayer2;
    }

    public void setLimitesEnemy(Rectangle limitesEnemy) {
        this.limitesEnemy = limitesEnemy;
    }
    
    
    
    private void colisaoBola() {
        //Colisão lateral
        if (getX() + (getDx() * getSpeed()) + getSpeed() >= Game.getGameWidth() || getX() + (getDx() * getSpeed()) < 0) {
            setDx(getDx() * -1);
        }

        //Colisão objetos
        setLimites(new Rectangle((int) (getX() + (getDx() * getSpeed())), (int) (getY() + (getDy() * getSpeed())), getWidth(), getHeight()));
        setLimitesPlayer(new Rectangle(Game.getPlayer().getX(), Game.getPlayer().getY(), Game.getPlayer().getWidth(), Game.getPlayer().getHeight()));
        setLimitesPlayer2(new Rectangle((int) Game.getPlayer2().getX(), (int) Game.getPlayer2().getY(), Game.getPlayer2().getWidth(), Game.getPlayer2().getHeight()));
        setLimitesEnemy(new Rectangle((int) Game.getEnemy().getX(), (int) Game.getEnemy().getY(), Game.getEnemy().getWidth(), Game.getEnemy().getHeight()));

        if (getLimites().intersects(getLimitesPlayer())) {
            setAngle(new Random().nextInt(120 - 45) + 46);
            setDx(Math.cos(Math.toRadians(getAngle())));
            setDy(Math.sin(Math.toRadians(getAngle())));
            if (getDy() > 0) {
                setDy(getDy() * -1);
            }
        } else if (getLimites().intersects(getLimitesEnemy()) || getLimites().intersects(getLimitesPlayer2())) {
            setAngle(new Random().nextInt(120 - 45) + 46);
            setDx(Math.cos(Math.toRadians(getAngle())));
            setDy(Math.sin(Math.toRadians(getAngle())));
            if (getDy() < 0) {
                setDy(getDy() * -1);
            }
        }
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
