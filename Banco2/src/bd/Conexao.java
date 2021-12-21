package bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	// M�todo para conectar
	public static Connection conectar() {
		
		// Atributo
		Connection con = null;
		
		// Tentativa
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "password");
			//System.out.println("Conex�o efetuada com sucesso!");
		}catch(Exception falha) {
			System.out.println("Falha ao conectar: "+falha.getMessage());
		}
		
		// Retornar
		return con;
		
	}
	
}