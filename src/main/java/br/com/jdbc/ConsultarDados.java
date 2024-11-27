package br.com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultarDados {
    public static void main(String[] args) {
        String sql = "SELECT * FROM pessoas";

        try (Connection connection = ConexaoOracle.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Idade: " + rs.getInt("idade"));
                System.out.println("---------------------------");
            }

        } catch (Exception e) {
            System.err.println("Erro ao consultar dados: " + e.getMessage());
        }
    }
}
