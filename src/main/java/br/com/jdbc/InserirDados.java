package br.com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InserirDados {
    public static void main(String[] args) {
        String sql = "INSERT INTO pessoas (nome, idade) VALUES (?, ?)";

        try (Connection connection = ConexaoOracle.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            // Configurar os parâmetros
            stmt.setString(1, "João Silva");
            stmt.setInt(2, 30);

            // Executar o comando
            int rowsInserted = stmt.executeUpdate();
            System.out.println(rowsInserted + " registro(s) inserido(s) com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro ao inserir dados: " + e.getMessage());
        }
    }
}
