package com.mycompany.cursosfat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TelaAluno extends JFrame {

    // Componentes da interface
    private JTextField campoNome;
    private JTextField campoSobrenome;
    private JTextArea areaTexto;
    private JButton botaoCadastrar;
    private JButton botaoListar;
    private JButton botaoDeletar; // ✅ Adicionado

    public TelaAluno() {
        super("Cadastro de Alunos - Cursos FAT");
        setLayout(new BorderLayout());

        // ✅ PAINEL SUPERIOR - Campos de entrada
        JPanel painelCampos = new JPanel(new GridLayout(2, 2, 5, 5));
        painelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        painelCampos.add(new JLabel("Nome:"));
        campoNome = new JTextField();
        painelCampos.add(campoNome);

        painelCampos.add(new JLabel("Sobrenome:"));
        campoSobrenome = new JTextField();
        painelCampos.add(campoSobrenome);

        // PAINEL DOS BOTÕES
        JPanel painelBotoes = new JPanel(new GridLayout(1, 3, 5, 5));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        


        botaoCadastrar = new JButton("Cadastrar");
        botaoListar = new JButton("Listar");
        botaoDeletar = new JButton("Deletar");
       
        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoListar);
        painelBotoes.add(botaoDeletar);

        // ✅ PAINEL CENTRAL - junta campos e botões
        JPanel painelSuperior = new JPanel(new BorderLayout());
        painelSuperior.add(painelCampos, BorderLayout.NORTH);
        painelSuperior.add(painelBotoes, BorderLayout.SOUTH);

        add(painelSuperior, BorderLayout.NORTH);

        // ✅ ÁREA DE TEXTO
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll, BorderLayout.CENTER);

        // ✅ Eventos
        botaoCadastrar.addActionListener(e -> cadastrarAluno());
        botaoListar.addActionListener(e -> listarAlunos());
        botaoDeletar.addActionListener(e -> deletarAluno());

        // ✅ Configurações da janela
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centraliza
        setVisible(true);
    }

    private void cadastrarAluno() {
        String nome = campoNome.getText();
        String sobrenome = campoSobrenome.getText();

        if (nome.isEmpty() || sobrenome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            return;
        }

        try (Connection conexao = Conexao.getConexao()) {
            String sql = "INSERT INTO Alunos (nome, sobrenome) VALUES (?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, sobrenome);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
            campoNome.setText("");
            campoSobrenome.setText("");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + e.getMessage());
        }
    }

    private void listarAlunos() {
        areaTexto.setText("");

        try (Connection conexao = Conexao.getConexao()) {
            String sql = "SELECT * FROM Alunos";
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String linha = rs.getInt("id") + " - " + rs.getString("nome") + " " + rs.getString("sobrenome");
                areaTexto.append(linha + "\n");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar: " + e.getMessage());
        }
    }

    private void deletarAluno() {
    String idStr = JOptionPane.showInputDialog(this, "Digite o ID do aluno a ser deletado:");
    if (idStr == null || idStr.trim().isEmpty()) {
        return;
    }
    try {
        int id = Integer.parseInt(idStr.trim());
        try (Connection conexao = Conexao.getConexao()) {
            String sql = "DELETE FROM Alunos WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Aluno deletado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Aluno não encontrado.");
            }
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID inválido.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao deletar: " + e.getMessage());
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaAluno());
    }
}
