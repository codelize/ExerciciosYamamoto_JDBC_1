package br.com.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ImportarDados {
    public static void main(String[] args) {
        String arquivoCSV = "alunos.csv";
        String sql = "INSERT INTO ALUNOS (ID, NOME, IDADE, CURSO) VALUES (?, ?, ?, ?)";

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV));
             Connection connection = ConexaoOracle.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            String linha;
            br.readLine(); // Pular a linha de cabeçalho
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(","); // Separar os campos por vírgula
                stmt.setInt(1, Integer.parseInt(dados[0])); // ID
                stmt.setString(2, dados[1]); // Nome
                stmt.setInt(3, Integer.parseInt(dados[2])); // Idade
                stmt.setString(4, dados[3]); // Curso

                stmt.executeUpdate();
            }

            System.out.println("Dados importados com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro ao importar dados: " + e.getMessage());
        }
    }
}
