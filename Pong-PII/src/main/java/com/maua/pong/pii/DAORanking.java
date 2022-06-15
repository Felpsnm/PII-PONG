package com.maua.pong.pii;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAORanking {

    private static String rankingText = "RANKING:";
    private static int idNome;

    public static String mostrarPontos() {
        String sql = "select Nome, NumeroDepontos FROM RANKING INNER JOIN LOGIN ON ID_LOGIN WHERE RANKING.ID_LOGIN = Login.ID";
        try ( Connection conn = ConnectionFactory.obtemConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            try ( ResultSet rs = ps.executeQuery()) {
                rankingText = "RANKING:";
                while (rs.next()) {
                    String rankingNome = rs.getString("Nome");
                    String rankingPontos = rs.getString("NumeroDepontos");
                    rankingText = rankingText + '\n' + rankingNome + " " + rankingPontos;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return rankingText;
        }
    }

    public static void inserirPontos(int pontos, String login) {
        String sql = "UPDATE RANKING SET NumeroDepontos = (select NumeroDepontos + ?) WHERE ID_LOGIN = ?;";
        try ( Connection conn = ConnectionFactory.obtemConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pontos);
            ps.setInt(2, getIDNome(login));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int getIDNome(String login) {
        String sql = "select ID_LOGIN,Nome from Ranking inner join LOGIN on ID_LOGIN WHERE ID_LOGIN = LOGIN.ID AND Nome = ?";
        try ( Connection conn = ConnectionFactory.obtemConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, login);
            try ( ResultSet rs = ps.executeQuery()) {
                rs.next();
                idNome = rs.getInt("ID_LOGIN");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return idNome;
        }
    }
}
