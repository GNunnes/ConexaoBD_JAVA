package com.mycompany.cursosfat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final String URL = "jdbc:mysql://localhost:3306/FAT";
    private final String USUARIO = "root";
    private final String SENHA = "";

    public Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
            return null;
        }
    }

    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO Alunos (nome, sobrenome) VALUES (?, ?)";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getSobrenome());
            stmt.executeUpdate();
            System.out.println("✅ Aluno inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir aluno: " + e.getMessage());
        }
    }

    public List<Aluno> listarTodos() {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM Alunos";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setSobrenome(rs.getString("sobrenome"));
                lista.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
        }

        return lista;
    }
}
