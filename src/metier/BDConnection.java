package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {

	public BDConnection() {
		// TODO Auto-generated constructor stub
	}
	
	public Connection seconnecter() {
		//initialiser un objet connection
		Connection cnx = null;
		//2. definir le chemin d'acces a la BD 
		String url = "jdbc:mysql://localhost:3307/gestiontribunal";
		//3. definir l'utilisateur
		String user = "User";
		String pwd = "User1234";
		//4. charger le pilote 
        	try {
        		// Class.forName("com.mysql.cj.jdbc.Driver");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver Compatible");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Driver Non Compatible");
				e.printStackTrace();
				
			}
        	//ouvrir la connection
        	try {
				cnx=DriverManager.getConnection(url,user,pwd);
				if(cnx!=null) System.out.println("Connection etablie");
				else System.out.println("Connection Non etablie!");	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Connection Non etablie!");
				e.printStackTrace();
			}
        	
		
        
		
		return cnx;
	}
	public static void main(String []args) {
		new BDConnection().seconnecter();
	}
}
