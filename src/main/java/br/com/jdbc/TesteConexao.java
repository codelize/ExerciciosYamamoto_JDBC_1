package br.com.jdbc;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        try (Connection connection = ConexaoOracle.getConnection()) {
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
    }
}
