package com.maua.pong.pii;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Menu {

    private final String[] options = {"um jogador", "dois jogadores", "sair"};

    private int currentOption = 0;
    private final int maxOption = options.length - 1;
    public boolean down, up, enter;
    public boolean pause = false;

    private void selecaoMenu() {
        if (up) {
            up = false;
            currentOption--;
            if (currentOption < 0) {
                currentOption = maxOption;
            }
        }
        if (down) {
            down = false;
            currentOption++;
            if (currentOption > maxOption) {
                currentOption = 0;
            }
        }
        if (enter) {
            enter = false;
            if (null != options[currentOption]) {
                switch (options[currentOption]) {
                    case "um jogador":
                        Game.gameState = "SINGLEPLAYER";
                        pause = false;
                        break;
                    case "dois jogadores":
                        Game.gameState = "COOP";
                        pause = false;
                        break;
                    case "sair":
                        System.exit(1);
                    default:
                        break;
                }
            }
        }
    }

    private void renderizacaoMenu(Graphics g) {
        //Plano de fundo
        g.setColor(new Color(0, 0, 0, 100));
        g.fillRect(0, 0, Game.gameWidth * Game.gameScale, Game.gameHeight * Game.gameScale);

        //Título
        g.setColor(Color.green);
        g.setFont(new Font("arial", Font.BOLD, 12));
        g.drawString(">PONG QUIZ JAVA<", (Game.gameWidth * Game.gameScale / 2 - 215), (Game.gameHeight * Game.gameScale) / 2 - 165);

        //Opções
        g.setColor(Color.yellow);
        g.setFont(new Font("arial", Font.BOLD, 10));
        if (pause == false) {
            g.drawString("Um Jogador", (Game.gameWidth * Game.gameScale) / 2 - 205, (Game.gameHeight * Game.gameScale) / 2 - 150);
        }
        if (pause == false) {
            g.drawString("Dois Jogadores", (Game.gameWidth * Game.gameScale) / 2 - 205, (Game.gameHeight * Game.gameScale) / 2 - 140);
        }

        g.drawString("Sair", (Game.gameWidth * Game.gameScale) / 2 - 205, (Game.gameHeight * Game.gameScale) / 2 - 130);

        if (null != options[currentOption]) {
            switch (options[currentOption]) {
                case "um jogador" -> {
                    g.setColor(Color.white);
                    g.drawString(">", (Game.gameWidth * Game.gameScale) / 2 - 215, (Game.gameHeight * Game.gameScale) / 2 - 150);
                }
                case "dois jogadores" -> {
                    g.setColor(Color.white);
                    g.drawString(">", (Game.gameWidth * Game.gameScale) / 2 - 215, (Game.gameHeight * Game.gameScale) / 2 - 140);
                }
                case "sair" -> {
                    g.setColor(Color.white);
                    g.drawString(">", (Game.gameWidth * Game.gameScale) / 2 - 215, (Game.gameHeight * Game.gameScale) / 2 - 130);
                }
                default -> {
                }
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
