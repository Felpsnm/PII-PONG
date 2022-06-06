package com.maua.pong.pii;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOLogin {
    public boolean existe(Usuario usuario) throws Exception {
        String sql = "SELECT * FROM LOGIN Where nome = ? AND senha = ?";
        try (
            Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            try (
                ResultSet rs = ps.executeQuery()
            ) {
                return rs.next();
            }
        }
    }
}
