package com.maua.pong.pii;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Quiz {

    private boolean player = false;
    private boolean player2orEnemy = false;
    
    //Construtor
    public Quiz() {
    }
    
    //Getters
    public boolean isPlayer() {
        return player;
    }

    public boolean isPlayer2orEnemy() {
        return player2orEnemy;
    }
    
    //Setters
    public void setPlayer(boolean player) {
        this.player = player;
    }

    public void setPlayer2orEnemy(boolean player2orEnemy) {
        this.player2orEnemy = player2orEnemy;
    }
    
    private String pergunta(int i) {
        String pergunta[] = {"Eu sou uma pergunta"};

        return pergunta[i];
    }
    
    //Métodos
    private void renderizacaoQuiz(Graphics g) {
        g.setColor(new Color(255, 255, 255, 100));
        g.fillRect(0, 0, Game.getGameWidthStaggered(), Game.getGameHeightStaggered());

        g.setColor(Color.green);
        g.setFont(new Font("arial", Font.PLAIN, 10));
        if (isPlayer()) {
            g.drawString(">--QUIZ | Player 1--<", (Game.getGameWidthStaggered() / 2 - 207), (Game.getGameHeightStaggered()) / 2 - 165);
        } else if (isPlayer2orEnemy()) {
            g.drawString(">--QUIZ | Player 2--<", (Game.getGameWidthStaggered() / 2 - 207), (Game.getGameHeightStaggered()) / 2 - 165);
        }

        g.setFont(new Font("arial", Font.PLAIN, 9));

        g.drawString(pergunta(0), (Game.getGameWidthStaggered() / 2 - 200), (Game.getGameHeightStaggered()) / 2 - 140);

    }

    public void tick() {

    }

    public void render(Graphics g) {
        renderizacaoQuiz(g);
    }
}
