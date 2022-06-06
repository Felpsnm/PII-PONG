package com.maua.pong.pii;

public class Quiz {

    private static boolean player;
    private static boolean player2;
    
    private static QuizTela quizTela;
    private static DAOPergunta daoPergunta;

    public Quiz() {
        player = false;
        player2 = false;
        daoPergunta = new DAOPergunta();
        quizTela = new QuizTela();
        
    }

    //Getters
    public static boolean isPlayer() {
        return player;
    }

    public static boolean isPlayer2() {
        return player2;
    }
    

    //Setters
    public void setPlayer(boolean player) {
        this.player = player;
    }

    public void setPlayer2(boolean player2) {
        this.player2 = player2;
    }

    //Métodos
    public static String getPergunta() {
        return daoPergunta.obterPergunta().getPergunta();
    }
    
    public static String getAlternativa1() {
        return daoPergunta.obterPergunta().getAlternativa1();
    }
    
    public static String getAlternativa2() {
        return daoPergunta.obterPergunta().getAlternativa2();
    }
    
    public static String getAlternativa3() {
        return daoPergunta.obterPergunta().getAlternativa3();
    }
    
    public static int getResposta() {
        return daoPergunta.obterPergunta().getResposta();
    }
    
    public static void renderizacaoQuiz() {
        quizTela.setVisible(true);
    }
    

}
