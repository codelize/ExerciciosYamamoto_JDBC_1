package br.com.jdbc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExportarDados {
    public static void main(String[] args) {
        String arquivoCSV = "alunos_exportados.csv"; // Nome do arquivo de saída
        String sql = "SELECT * FROM alunos"; // Consulta para buscar os dados

        try (Connection connection = ConexaoOracle.getConnection();
             BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoCSV))) {

            // Escrever cabeçalho no arquivo
            writer.write("id,nome,idade");
            writer.newLine();

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Percorrer os dados e gravar no arquivo
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");

                // Escrever os dados no formato CSV
                writer.write(id + "," + nome + "," + idade);
                writer.newLine();
            }

            System.out.println("Dados exportados com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro ao exportar dados: " + e.getMessage());
        }
    }
}
