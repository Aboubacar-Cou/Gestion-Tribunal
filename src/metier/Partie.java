package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Partie {
	private String idpartie;
	private String libpartie;
	private String adrpartie;
	private String telpartie;

	public Partie() {
		// Constructeur vide
	}

	public String getIdpartie() {
		return idpartie;
	}

	public void setIdpartie(String idpartie) {
		this.idpartie = idpartie;
	}

	public String getLibpartie() {
		return libpartie;
	}

	public void setLibpartie(String libpartie) {
		this.libpartie = libpartie;
	}

	public String getAdrpartie() {
		return adrpartie;
	}

	public void setAdrpartie(String adrpartie) {
		this.adrpartie = adrpartie;
	}

	public String getTelpartie() {
		return telpartie;
	}

	public void setTelpartie(String telpartie) {
		this.telpartie = telpartie;
	}

	// Enregistrer une nouvelle partie dans la base de données
	public void Enregistrer(Partie part) {
		Connection cnx = null;
		BDConnection bd = new BDConnection();
		cnx = bd.seconnecter();
		String sql = "insert into partie values(?,?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = cnx.prepareStatement(sql);
			pst.setString(1, part.getIdpartie());
			pst.setString(2, part.getLibpartie());
			pst.setString(3, part.getAdrpartie());
			pst.setString(4, part.getTelpartie());
			pst.executeUpdate();
			
			pst.close(); 
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Récupérer la liste complète de toutes les parties
	public List<Partie> getpartie(){
		Connection cnx = null;
		BDConnection bd = new BDConnection();
		cnx = bd.seconnecter();
		List<Partie> lpart = new ArrayList<Partie>();
		String sql = "select * from partie";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = cnx.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Partie part = new Partie();
				part.setIdpartie(rs.getString(1));
				part.setLibpartie(rs.getString(2));
				part.setAdrpartie(rs.getString(3));
				part.setTelpartie(rs.getString(4));
				lpart.add(part);	
			}
			rs.close(); 
			st.close(); 
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lpart;
	}

	// Rechercher une partie unique à partir de son code (Id)
	public Partie getpartiebycode(String idpartie) {
    	Connection cnx = null;
    	BDConnection bd = new BDConnection();
    	cnx = bd.seconnecter();
    	Partie part = null; // Initialisation à null s'il n'existe pas
    	String sql = "select * from partie where idpartie=?";
    	PreparedStatement pst = null;
    	ResultSet rs = null;
    	try {
			pst = cnx.prepareStatement(sql);
			pst.setString(1, idpartie);
			rs = pst.executeQuery();
			if(rs.next()) { // Utilisation de if au lieu de while car la clé primaire est unique
				part = new Partie();
				part.setIdpartie(rs.getString(1));
				part.setLibpartie(rs.getString(2));
				part.setAdrpartie(rs.getString(3));
				part.setTelpartie(rs.getString(4));
			}
			rs.close(); 
			pst.close(); 
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return part;
    }

	// Mettre à jour une partie existante (Ordre des paramètres SQL réaligné)
	public void majpartie(String idpartie, Partie part){
	    Connection cnx = null;
	    BDConnection bd = new BDConnection();
	    cnx = bd.seconnecter();
	    String sql = "update partie set libpartie=?, adrpartie=?, telpartie=? where idpartie=?";
	    PreparedStatement pst = null;
	    try {
	        pst = cnx.prepareStatement(sql);
	        
	        // Alignement strict sur les ? de la requête SQL
	        pst.setString(1, part.getLibpartie()); // 1er ? = libpartie
	        pst.setString(2, part.getAdrpartie()); // 2ème ? = adrpartie
	        pst.setString(3, part.getTelpartie()); // 3ème ? = telpartie
	        pst.setString(4, idpartie);            // 4ème ? = clause WHERE
	        
	        int i = pst.executeUpdate();
	        if(i != 0) {
	        	System.out.println("Mise a jour de la partie effectuee avec succes !");
	        } else {
	        	System.out.println("Mise a jour echouee : aucun enregistrement trouve.");
	        }

	        pst.close(); 
	        cnx.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	// Supprimer définitivement une partie de la base de données
	public void supppartie(String idpartie) {
		Connection cnx = null;
		BDConnection bd = new BDConnection();
		cnx = bd.seconnecter();
		String sql = "delete from partie where idpartie=?";
		PreparedStatement pst = null;
		try {
			pst = cnx.prepareStatement(sql);
			pst.setString(1, idpartie);
			pst.executeUpdate();
			
			pst.close(); 
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
