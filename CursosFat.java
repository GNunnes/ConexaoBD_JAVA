package com.mycompany.cursosfat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CursosFat {

    public static void main(String[] args) {
        AlunoDAO dao = new AlunoDAO();

        // Criar novo aluno
        Aluno novo = new Aluno("Gustavo", "Ferreira");
        dao.inserir(novo);

        // Listar todos os alunos
        System.out.println("📋 Lista de alunos:");
        for (Aluno a : dao.listarTodos()) {
            System.out.println(a);
        }
    }
}