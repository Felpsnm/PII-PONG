package com.maua.pong.pii;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static String usuario = "root";
    private static String senha = "1234";
    private static String host = "localhost";
    private static String porta = "3306";
    private static String bd = "dbquiz";

    public static Connection obtemConexao() throws Exception {
        String url = String.format("jdbc:mysql://%s:%s/%s", host, porta, bd);
        return DriverManager.getConnection(url, usuario, senha);
    }
}
