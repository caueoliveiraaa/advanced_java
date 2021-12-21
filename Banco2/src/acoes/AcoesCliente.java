package acoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import bd.Conexao;
import modelos.Cliente;

public class AcoesCliente {

	// Cadastrar
	public static void cadastrar(Cliente c) {
		
		try {
			
			Connection conexao = Conexao.conectar();
			
			String sql = "INSERT INTO clientes (nome, idade, cidade) VALUES (?, ?, ?)"; 
			
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, c.getNome());
			pstmt.setInt(2, c.getIdade());
			pstmt.setString(3, c.getCidade());
			
			pstmt.execute();
			
		}catch(Exception erro) {
			System.out.println("Falha ao cadastrar " + erro.getMessage());
		}
		
	}
	
	// Listar
	public static DefaultTableModel listar() {
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Código");
		dtm.addColumn("Nome");
		dtm.addColumn("Idade");
		dtm.addColumn("Cidade");
		
		try {
			
			Connection conexao = Conexao.conectar();
			
			String sql = "SELECT * FROM clientes";
			
			Statement stmt = conexao.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				dtm.addRow(new Object[] {
					rs.getInt(1),
					rs.getString(2),
					rs.getInt(3),
					rs.getString(4)
				});
			}
			
		}catch(Exception erro) {
			System.out.println("Falha ao listar");
		}
		
		return dtm;
		
	}
	
	// Remover cliente
	public static void remover (int codigo) {
		
		// Tentativa
		try {
			
			Connection conexao = Conexao.conectar();
			
			String sql = "DELETE FROM clientes WHERE codigo = ?";
			
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			pstmt.setInt(1, codigo);  
			pstmt.execute();
			
		} catch(Exception erro) {
			System.out.println("Falha ao excluir!");
		}
		
	}
}
