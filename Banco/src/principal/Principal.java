package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import bd.Conexao;

public class Principal {
	public static void main(String[] args) {
		
//		// Cadastrar
//		try{
//			
//			// Iniciar conexão
//			Connection con = Conexao.conectar();
//			
//			// SQL
//			String sql = "INSERT INTO clientes (nome, idade, cidade) VALUES(?, ?, ?)";
//			
//			// PreparedStament-> Efetuar o comando SQL
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, "Henrique");
//			pstmt.setInt(2, 26);
//			pstmt.setString(3, "Joinville");
//			
//			// Executar
//			pstmt.execute();
//			
//			//Retorno
//			System.out.println("Cadastro efetuado com sucesso");
//			
//			
//			
//		}catch(Exception erro) {
//			System.out.println("Falha ao cadastrar "+erro.getMessage());
//		}
		
		
		// Selecionar
		try {
			
			// Conexão
			Connection con = Conexao.conectar();
			
			//SQL
			String sql = "SELECT * FROM clientes";
			
			// Statement
			Statement stmt = con.createStatement();
			
			// ResultSet-> Vetor para armazenar os dados do SELECT
			ResultSet rs = stmt.executeQuery(sql);
			
			// Listar dados
			while(rs.next()) {
				System.out.println(rs.getString(2));
			}
			
		}catch(Exception erro){
			System.out.println("Falha ao selecionar");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
