package com.maua.pong.pii;

import javax.swing.JFrame;

public class Main {
    public static Game game;

    public static void main(String[] args) {
        createGameInstance(0, 0);
        JFrame frame = new JFrame("Pong");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        new Thread(game).start();
    }
    
    public static void createGameInstance(int pontosPlayer, int pontosPlayer2) {
        game = new Game(pontosPlayer, pontosPlayer2);
        
    }
}
