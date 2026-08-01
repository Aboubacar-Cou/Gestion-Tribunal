package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Magistrat {
	private String idmag;
	private String nommag;
	private String prenommag;

	public Magistrat() {
		// Constructeur vide
	}

	public String getIdmag() {
		return idmag;
	}

	public void setIdmag(String idmag) {
		this.idmag = idmag;
	}

	public String getNommag() {
		return nommag;
	}

	public void setNommag(String nommag) {
		this.nommag = nommag;
	}

	public String getPrenommag() {
		return prenommag;
	}

	public void setPrenommag(String prenommag) {
		this.prenommag = prenommag;
	}

	// Ajouter un nouveau magistrat
	public void Enregistrer(Magistrat mag) {
		Connection cnx = null;
		BDConnection bd = new BDConnection();
		cnx = bd.seconnecter();
		String sql = "insert into magistrat values(?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = cnx.prepareStatement(sql);
			pst.setString(1, mag.getIdmag());
			pst.setString(2, mag.getNommag());
			pst.setString(3, mag.getPrenommag());
			pst.executeUpdate();
			
			pst.close(); 
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Récupérer tous les magistrats (Utilisé pour rafraîchir le tableau)
	public List<Magistrat> getmagistrat(){
		Connection cnx = null;
		BDConnection bd = new BDConnection();
		cnx = bd.seconnecter();
		List<Magistrat> lmag = new ArrayList<Magistrat>();
		String sql = "select * from magistrat";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = cnx.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Magistrat mag = new Magistrat();
				mag.setIdmag(rs.getString(1));
				mag.setNommag(rs.getString(2));
				mag.setPrenommag(rs.getString(3));
				lmag.add(mag);	
			}
			rs.close(); 
			st.close(); 
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lmag;
	}

	// Rechercher un magistrat unique par son code
	public Magistrat getmagistratbycode(String idmag) {
    	Connection cnx = null;
    	BDConnection bd = new BDConnection();
    	cnx = bd.seconnecter();
    	Magistrat mag = null;
    	String sql = "select * from magistrat where idmag=?";
    	PreparedStatement pst = null;
    	ResultSet rs = null;
    	try {
			pst = cnx.prepareStatement(sql);
			pst.setString(1, idmag);
			rs = pst.executeQuery();
			if(rs.next()) {
				mag = new Magistrat();
				mag.setIdmag(rs.getString(1));
				mag.setNommag(rs.getString(2));
				mag.setPrenommag(rs.getString(3));
			}
			rs.close(); 
			pst.close(); 
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return mag;
    }

	// Mettre à jour un magistrat existant
	public void majmagistrat(String idmag, Magistrat mag){
	    Connection cnx = null;
	    BDConnection bd = new BDConnection();
	    cnx = bd.seconnecter();
	    String sql = "update magistrat set nommag=?, prenommag=? where idmag=?";
	    PreparedStatement pst = null;
	    try {
	        pst = cnx.prepareStatement(sql);
	        // ALIGNEMENT CORRECT DES INDEX JDBC
	        pst.setString(1, mag.getNommag());    
	        pst.setString(2, mag.getPrenommag()); 
	        pst.setString(3, idmag);             
	        pst.executeUpdate();
	        pst.close(); 
	        cnx.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	// Supprimer définitivement un magistrat
	public void suppmagistrat(String idmag) {
	    Connection cnx = null;
	    BDConnection bd = new BDConnection();
	    cnx = bd.seconnecter();
	    PreparedStatement pst = null;
	    try {
	        // 1. On dit à MySQL de ne pas bloquer si le magistrat est lié à une affaire
	        Statement st = cnx.createStatement();
	        st.executeUpdate("SET FOREIGN_KEY_CHECKS=0");
	        st.close();

	        // 2. On exécute la suppression
	        String sql = "delete from magistrat where idmag=?";
	        pst = cnx.prepareStatement(sql);
	        pst.setString(1, idmag);
	        pst.executeUpdate();
	        
	        // 3. On réactive la sécurité MySQL
	        Statement st2 = cnx.createStatement();
	        st2.executeUpdate("SET FOREIGN_KEY_CHECKS=1");
	        st2.close();

	        pst.close(); 
	        cnx.close();
	    } catch (SQLException e) {
	        System.err.println("Erreur fatale : " + e.getMessage());
	        e.printStackTrace();
	    }
	}
}
	