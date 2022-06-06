package com.maua.pong.pii;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Menu {

    private final String[] options;
    private int currentOption;
    private final int maxOption;
    private boolean down, up, enter;
    
    //Construtor
    public Menu() {
        options = new String[]{"um jogador", "dois jogadores", "sair"};
        currentOption = 0;
        maxOption = options.length - 1;       
    }
    
    //Getters
    public boolean isDown() {
        return down;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isEnter() {
        return enter;
    }
    
    //Setters
    public void setDown(boolean down) {
        this.down = down;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setEnter(boolean enter) {
        this.enter = enter;
    }
    
    //Métodos
    private void selecaoMenu() {
        if (up) {
            up = false;
            currentOption--;
            if (currentOption < 0) {
                currentOption = maxOption;
            }
        } else if (down) {
                down = false;
                currentOption++;
                if (currentOption > maxOption) {
                    currentOption = 0;
                }
        } else if (enter) {
            enter = false;
            switch (options[currentOption]) {
                case "um jogador" -> {
                    Game.setGameState("SINGLEPLAYER");
                }
                case "dois jogadores" -> {
                    Game.setGameState("COOP");
                }
                case "sair" -> {
                    Game.setGameState("CLOSE");
                }
            }
        }       
    }

    private void renderizacaoMenu(Graphics g) {               
        //Plano de fundo
        g.setColor(new Color(0, 0, 0, 100));
        g.fillRect(0, 0, Game.getGameWidthStaggered(), Game.getGameHeightStaggered());

        //Título
        g.setColor(Color.green);
        g.setFont(new Font("arial", Font.BOLD, 12));
        g.drawString(">PONG QUIZ JAVA<", (Game.getGameWidthStaggered() / 2 - 215), (Game.getGameHeightStaggered()) / 2 - 165);

        //Opções
        g.setColor(Color.yellow);
        g.setFont(new Font("arial", Font.BOLD, 10));
        
        g.drawString("Um Jogador", (Game.getGameWidthStaggered()) / 2 - 205, (Game.getGameHeightStaggered()) / 2 - 150);
        g.drawString("Dois Jogadores", (Game.getGameWidthStaggered()) / 2 - 205, (Game.getGameHeightStaggered()) / 2 - 140);
        g.drawString("Sair", (Game.getGameWidthStaggered()) / 2 - 205, (Game.getGameHeightStaggered()) / 2 - 130);

        switch (options[currentOption]) {
            case "um jogador" -> {
                g.setColor(Color.white);
                g.drawString(">", (Game.getGameWidthStaggered()) / 2 - 215, (Game.getGameHeightStaggered()) / 2 - 150);
            }
            case "dois jogadores" -> {
                g.setColor(Color.white);
                g.drawString(">", (Game.getGameWidthStaggered()) / 2 - 215, (Game.getGameHeightStaggered()) / 2 - 140);
            }
            case "sair" -> {
                g.setColor(Color.white);
                g.drawString(">", (Game.getGameWidthStaggered()) / 2 - 215, (Game.getGameHeightStaggered()) / 2 - 130);
            }
        }
    }

    public void tick() {
        selecaoMenu();
    }

    public void render(Graphics g) {
        renderizacaoMenu(g);
    }
}
