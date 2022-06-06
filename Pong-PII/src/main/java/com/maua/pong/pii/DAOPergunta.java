package com.maua.pong.pii;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class DAOPergunta {
    private Random random = new Random();
    private final int numero = random.nextInt(19) + 1;
    private Pergunta p = new Pergunta();

    public Pergunta obterPergunta() {
        String sql = "SELECT * FROM Quiz WHERE idPerguntas = ?";
        try ( Connection conn = ConnectionFactory.obtemConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numero);
                try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                String pergunta = rs.getString("Perguntas");
                String alternativa1 = rs.getString("Alternativa1");
                String alternativa2 = rs.getString("Alternativa2");
                String alternativa3 = rs.getString("Alternativa3");
                String resposta = rs.getString("Resposta");
                p.setPergunta(pergunta);
                p.setAlternativa1(alternativa1);
                p.setAlternativa2(alternativa2);
                p.setAlternativa3(alternativa3);
                p.setResposta(resposta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return p;
        }
    }

}
