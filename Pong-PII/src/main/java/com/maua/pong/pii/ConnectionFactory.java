
package com.maua.pong.pii;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private final String usuario;
    private final String senha;
    private final String host;
    private final String porta;
    private final String bd;

    public ConnectionFactory() {
        this.bd = "db_quiz";
        this.porta = "3306";
        this.usuario = "root";
        this.senha = "1234";
        this.host = "localhost";
    }

    public Connection obtemConexao() {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + bd, usuario, senha);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}