package bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	// Method to connect 
	
	public static Connection conectar() {
		
		// Atributo
		Connection con = null;
		
		// Tentativa
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "password");
					
			// System.out.println("Conexão efetuada com sucesso!");
			
		}catch(Exception falha) {
			
			System.out.println("Falha ao conectar: "+falha.getMessage());
			
		}
		
		// Retornar 
		return con;
		
		
	}
	
	
	
	
}
