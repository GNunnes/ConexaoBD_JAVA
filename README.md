# 🎓 Sistema de Cadastro de Alunos

![Java](https://img.shields.io/badge/Java-17+-red?style=flat&logo=java)
![Java](https://img.shields.io/badge/Java-Swing-orange?logo=java&style=flat-square)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue?logo=mysql&style=flat-square)

> Projeto prático em Java Swing com banco de dados MySQL e JDBC, ideal para aprendizado e prática de desenvolvimento com GUI.

---

## ✨ Funcionalidades

- ✅ **Cadastro de Alunos:** Insira nome e sobrenome e armazene no banco.
- 📋 **Listagem de Alunos:** Visualize todos os registros com ID.
- ❌ **Exclusão de Alunos:** Delete um aluno pelo ID.
- 🖥️ **Interface Gráfica Amigável:** Criada com Java Swing.
- 🛢️ **Integração com MySQL:** Utilizando JDBC.

---

## 🧰 Tecnologias Utilizadas

| Tecnologia | Função |
|------------|--------|
| `Java` | Lógica e estrutura do sistema |
| `Swing` | Interface gráfica |
| `JDBC` | Comunicação com banco de dados |
| `MySQL` | Armazenamento relacional |
| `NetBeans IDE` | Ambiente de desenvolvimento |

---

## 🚀 Como Executar o Projeto

### ✔️ Pré-requisitos

- Java JDK 8+
- MySQL Server
- NetBeans IDE 8.2 ou superior
- Driver JDBC (MySQL Connector/J)

### 📦 Etapas

1. **Clone o repositório**
```bash
   git clone https://github.com/SEU_USUARIO/cursosfat.git
```
   
2. **Crie o banco de dados MySQL**


```sql
CREATE DATABASE FAT;
USE FAT;
CREATE TABLE Alunos (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) NOT NULL,
sobrenome VARCHAR(255) NOT NULL);
```
3. **Abra no NetBeans**
   - File > Open Project... e selecione a pasta cursosfat.
<br><br>
4. **Adicione o driver JDBC**
   - Clique com botão direito em Libraries > Add JAR/Folder... e selecione o .jar do MySQL Connector.

5. **Execute**
   - Clique com botão direito em TelaAluno.java e selecione Run File.
<br><br>
### 🗂️ Estrutura do Projeto

```
cursosfat/
├── src/
│   └── com/
│       └── mycompany/
│           └── cursosfat/
│               ├── Aluno.java         // Modelo do aluno
│               ├── AlunoDAO.java      // Acesso ao banco
│               ├── Conexao.java       // Conexão JDBC
│               └── TelaAluno.java     // Interface gráfica
├── nbproject/                         // Arquivos do NetBeans
└── build.xml                          // Script de build
```
### 📄 Licença

Este projeto está sob a licença MIT.
<br>
Veja o arquivo LICENSE para mais detalhes.
<br>

Desenvolvedor em transição de carreira, apaixonado por tecnologia, qualidade de código e boas práticas. Sempre aprendendo, sempre evoluindo. 🚀

### 👤 Desenvolvido por

Gustavo N. Bezerra - [LinkedIn](https://www.linkedin.com/in/gustavo-nunnes) | [GitHub](https://github.com/GNunnes) |<i>gustavonunnes@hotmail.com</i> 