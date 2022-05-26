package com.maua.pong.pii;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Quiz {

    public boolean player = true;
    public boolean player2 = false;
    public boolean enemy = false;

    private String pergunta(int i) {
        String pergunta[] = {"Eu sou uma pergunta"};

        return pergunta[i];
    }

    private void renderizacaoQuiz(Graphics g) {
        g.setColor(new Color(255, 255, 255, 100));
        g.fillRect(0, 0, Game.gameWidth * Game.gameScale, Game.gameHeight * Game.gameScale);

        g.setColor(Color.green);
        g.setFont(new Font("arial", Font.PLAIN, 10));
        if (player) {
            g.drawString(">--QUIZ | Player 1--<", (Game.gameWidth * Game.gameScale / 2 - 207), (Game.gameHeight * Game.gameScale) / 2 - 165);
        } else if (player2) {
            g.drawString(">--QUIZ | Player 2--<", (Game.gameWidth * Game.gameScale / 2 - 207), (Game.gameHeight * Game.gameScale) / 2 - 165);
        }

        g.setFont(new Font("arial", Font.PLAIN, 9));

        g.drawString(pergunta(0), (Game.gameWidth * Game.gameScale / 2 - 200), (Game.gameHeight * Game.gameScale) / 2 - 140);

    }

    public void tick() {

    }

    public void render(Graphics g) {
        renderizacaoQuiz(g);
    }
}
